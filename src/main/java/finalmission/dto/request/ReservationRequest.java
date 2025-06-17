package finalmission.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequest(LocalDate date, LocalTime startAt, int guest) {
}
