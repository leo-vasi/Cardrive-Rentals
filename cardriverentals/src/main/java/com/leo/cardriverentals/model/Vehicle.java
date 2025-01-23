package com.leo.cardriverentals.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicles")
public class Vehicle {

    public enum VehicleCategory {
        SEDAN, SUV, TRUCK, HATCHBACK, CONVERTIBLE
    }

    public enum AvailabilityStatus {
        AVAILABLE, RENTED, UNDER_MAINTENANCE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String model;

    @Column(name = "vehicle_brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "vehicle_year", nullable = false)
    private int year;

    @Column(name = "vehicle_license_plate", nullable = false, length = 7, unique = true)
    private String licencePlate;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_category", nullable = false)
    private VehicleCategory vehicleCategory;

    @Column(name = "vehicle_color", length = 30)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_availability_status", nullable = false)
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE;

    @CreationTimestamp
    @Column(name = "vehicle_created_at", updatable = false)
    private LocalDateTime vehicleCreatedAt;

    @UpdateTimestamp
    @Column(name = "vehicle_altered_at")
    private LocalDateTime vehicleAlteredAt;
}
