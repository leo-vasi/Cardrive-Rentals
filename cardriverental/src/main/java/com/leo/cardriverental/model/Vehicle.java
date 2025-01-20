package com.leo.cardriverental.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle {

    public enum Category {
        SEDAN, SUV, TRUCK, HATCHBACK, CONVERTIBLE
    }

    public enum AvailabilityStatus {
        AVAILABLE, RENTED, UNDER_MAINTENANCE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String model;

    @Column(name = "vehicle_brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "vehicle_year", nullable = false)
    private Integer year;

    @Column(name = "vehicle_licence_plate", nullable = false, unique = true, length = 7)
    private String licensePlate;

    @Column(name = "vehicle_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "vehicle_color", length = 30)
    private String color;

    @Column(name = "vehicle_price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @Column(name = "vehicle_availability_status", nullable = false)
    private AvailabilityStatus availabilityStatus;

    @Column(name = "vehicle_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "vehicle_altered_at")
    private LocalDateTime alteredAt;

    @PreUpdate
    public void updateTimestamp () {
        this.alteredAt = LocalDateTime.now();
    }
}
