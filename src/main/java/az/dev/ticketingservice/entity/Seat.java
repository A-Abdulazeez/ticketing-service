package az.dev.ticketingservice.entity;

import az.dev.ticketingservice.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "seats",
        uniqueConstraints = @UniqueConstraint(
                name = "seat_event_section_row_number",
                columnNames = {"event_id", "section", "row_label", "seat_number"}
        )
)
@Getter
@Setter
public class Seat {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String section;

    @Column(nullable = false)
    private String rowLabel;

    @Column(nullable = false)
    private int seatNumber;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal seatPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status = SeatStatus.AVAILABLE;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "held_by_id")
    private User heldBy;

    @Column
    private Instant holdExpiresAt;

    @Version
    private Long version;
}