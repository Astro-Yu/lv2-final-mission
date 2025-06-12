package finalmission.service;

import finalmission.domain.Member;
import finalmission.domain.Reservation;
import finalmission.infrastructure.ReservationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findReservationsByMemberId(Member member) {
        return reservationRepository.findByMemberId(member.getId());
    }
}
