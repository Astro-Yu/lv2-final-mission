package finalmission.controller;

import finalmission.domain.Member;
import finalmission.domain.Reservation;
import finalmission.dto.response.ReservationResponse;
import finalmission.service.ReservationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/my")
    public List<ReservationResponse> getMyReservations(Member member) {
        List<Reservation> reservations = reservationService.findReservationsByMemberId(member);
        return reservations.stream()
                .map(ReservationResponse::from)
                .toList();
    }
}
