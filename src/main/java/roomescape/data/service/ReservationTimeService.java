package roomescape.data.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import roomescape.data.dao.daoInterface.ReservationTimeDao;
import roomescape.data.dto.ReservationTimeRequest;
import roomescape.data.dto.ReservationTimeResponse;
import roomescape.data.entity.ReservationTime;

@Service
public class ReservationTimeService {

    private final ReservationTimeDao reservationTimeDao;

    public ReservationTimeService(ReservationTimeDao reservationTimeDao) {
        this.reservationTimeDao = reservationTimeDao;
    }

    public ReservationTimeResponse save(ReservationTimeRequest reservationTimeRequest) {
        ReservationTime reservationTime = reservationTimeDao.save(new ReservationTime(reservationTimeRequest.getTime()));
        return ReservationTimeResponse.from(reservationTime);
    }

    public List<ReservationTimeResponse> findAll() {
        List<ReservationTime> reservationTimes = reservationTimeDao.findAll();
        return reservationTimes.stream()
                .map((ReservationTimeResponse::from))
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        reservationTimeDao.deleteById(id);
    }
}
