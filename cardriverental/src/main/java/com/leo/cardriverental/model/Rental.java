package com.leo.cardriverental.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rentals")
public class Rental {

    public enum RentalStatus {
        ACTIVE, COMPLETED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "rental_start_date", nullable = false)
    private LocalDate rentalStartDate;

    @Column(name = "rental_end_date", nullable = false)
    private LocalDate rentalEndDate;

    @Column(name = "rental_return_date")
    private LocalDate returnDate;

    @Column(name = "rental_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus = RentalStatus.ACTIVE;

    @Column(name = "rental_total", nullable = false)
    private BigDecimal rentalTotal;

    @Column(name = "rental_penalty")
    private BigDecimal rentalPenalty = BigDecimal.ZERO;

    @Column(name = "rental_created_at", nullable = false, updatable = false)
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "rental_altered_at")
    private LocalDate alteredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "rental_status")
    private RentalStatus status;




    @PreUpdate
    public void updateTimestamp() {
        this.alteredAt = LocalDate.now();
    }

}
