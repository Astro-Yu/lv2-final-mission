package finalmission.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ReservationDateTime dateTime;

    @ManyToOne
    private Member member;

    @Embedded
    private Guest guest;

    public Reservation(final Long id, final ReservationDateTime dateTime, final Member member, final Guest guest) {
        this.id = id;
        this.dateTime = dateTime;
        this.member = member;
        this.guest = guest;
    }

    public Reservation() {
    }
}
