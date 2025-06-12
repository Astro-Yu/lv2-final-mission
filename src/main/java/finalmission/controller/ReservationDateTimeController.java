package finalmission.controller;

import finalmission.domain.ReservationDateTime;
import finalmission.dto.request.ReservationDateTimeRequest;
import finalmission.dto.response.ReservationDateTimeResponse;
import finalmission.service.ReservationDateTimeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservationDateTime")
public class ReservationDateTimeController {
    private final ReservationDateTimeService reservationDateTimeService;

    public ReservationDateTimeController(final ReservationDateTimeService reservationDateTimeService) {
        this.reservationDateTimeService = reservationDateTimeService;
    }

    @GetMapping
    public List<ReservationDateTimeResponse> getReservationTimes() {
        return reservationDateTimeService.findReservationDateTime()
                .stream()
                .map(ReservationDateTimeResponse::from)
                .toList();
    }

    @PostMapping
    public ResponseEntity<ReservationDateTimeResponse> createReservationTime(ReservationDateTimeRequest request) {
        ReservationDateTime reservationDateTime = reservationDateTimeService.saveReservationDateTime(request);
        ReservationDateTimeResponse response = ReservationDateTimeResponse.from(reservationDateTime);

        return ResponseEntity.ok(response);
    }
}
