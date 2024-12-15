package com.leo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate startDate;

    @Column(name = "rental_return_date", nullable = false)
    private LocalDate endDate;

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

    @PreUpdate
    public void updateTimestamp() {
        this.alteredAt = LocalDate.now();
    }

}
