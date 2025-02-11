package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rentals")
public class Rental {

    public enum RentalStatus {
        ACTIVE, COMPLETED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Long rentalId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "payment_method_id", nullable = true)
    private PaymentMethod paymentMethod;

    @Column(name = "rental_start_date", nullable = false)
    @NotNull
    private LocalDate rentalStartDate;

    @Column(name = "rental_end_date", nullable = false)
    @NotNull
    private LocalDate rentalEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "rental_status", nullable = false)
    @NotNull
    private RentalStatus rentalStatus = RentalStatus.ACTIVE;

    @NotNull
    @Positive
    @Column(name = "rental_total", nullable = false)
    private Double rentalTotal;

    @CreationTimestamp
    @Column(name = "rental_created_at", nullable = false)
    private LocalDateTime rentalCreatedAt;

    @UpdateTimestamp
    @Column(name = "rental_altered_at", nullable = false)
    private LocalDateTime rentalAlteredAt;

    @Column(name = "rental_return_date", nullable = true)
    private LocalDate rentalReturnDate;

    @Column(name = "rental_penalty", nullable = false)
    @PositiveOrZero
    private Double rentalPenalty = 0.00;
}
