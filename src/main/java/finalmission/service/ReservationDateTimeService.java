package finalmission.service;

import finalmission.domain.ReservationDateTime;
import finalmission.dto.request.ReservationDateTimeRequest;
import finalmission.exception.NotFoundDateTimeException;
import finalmission.infrastructure.ReservationDateTimeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservationDateTimeService {
    private final ReservationDateTimeRepository reservationDateTimeRepository;

    public ReservationDateTimeService(final ReservationDateTimeRepository reservationDateTimeRepository) {
        this.reservationDateTimeRepository = reservationDateTimeRepository;
    }

    public List<ReservationDateTime> findReservationDateTime() {
        return reservationDateTimeRepository.findAll();
    }

    public ReservationDateTime saveReservationDateTime(ReservationDateTimeRequest request) {
        ReservationDateTime reservationDateTime = request.toReservationDateTimeWithoutId();
        return reservationDateTimeRepository.save(reservationDateTime);
    }

    public void deleteReservationDateTime(Long id) {
        checkDuplication(id);
        reservationDateTimeRepository.deleteById(id);
    }

    private void checkDuplication(Long id) {
        if (!reservationDateTimeRepository.existsById(id)) {
            throw new NotFoundDateTimeException();
        }
    }
}
