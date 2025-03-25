package com.leo.cardriverentals.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
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
    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    @NotBlank(message = "O modelo do veículo é obrigatório")
    @Size(max = 50, message = "O modelo do veículo deve ter no máximo 50 caracteres")
    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String model;

    @NotBlank(message = "A marca do veículo é obrigatória")
    @Size(max = 50, message = "A marca do veículo deve ter no máximo 50 caracteres")
    @Column(name = "vehicle_brand", nullable = false, length = 50)
    private String brand;

    @NotNull(message = "O ano do veículo é obrigatório")
    @Min(value = 1886, message = "O ano do veículo deve ser maior ou igual a 1886")
    @Max(value = 2100, message = "O ano do veículo deve ser menor ou igual a 2100")
    @Column(name = "vehicle_year", nullable = false)
    private int year;

    @NotBlank(message = "A placa do veículo é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}\\d{4}$", message = "A placa deve estar no formato AAA9999")
    @Size(max = 7, message = "A placa do veículo deve ter exatamente 7 caracteres")
    @Column(name = "vehicle_license_plate", nullable = false, length = 7, unique = true)
    private String licencePlate;

    @NotNull(message = "A categoria do veículo é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_category", nullable = false)
    private VehicleCategory vehicleCategory;

    @Size(max = 30, message = "A cor do veículo deve ter no máximo 30 caracteres")
    @Column(name = "vehicle_color", length = 30)
    private String color;

    @NotNull(message = "O status de disponibilidade é obrigatório")
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

