package finalmission.infrastructure;

import finalmission.domain.ReservationDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDateTimeRepository extends JpaRepository<ReservationDateTime, Long> {
    ReservationDateTime findByDateAndStartAt(LocalDate date, LocalTime startAt);

    Optional<ReservationDateTime> findById(Long id);

}
