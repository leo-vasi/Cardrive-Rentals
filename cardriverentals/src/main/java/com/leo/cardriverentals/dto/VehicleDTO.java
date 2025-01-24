package com.leo.cardriverentals.dto;

import com.leo.cardriverentals.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long vehicleId;
    private String model;
    private String brand;
    private int year;
    private String licencePlate;
    private Vehicle.VehicleCategory vehicleCategory;
    private String color;
    private Vehicle.AvailabilityStatus availabilityStatus;

}
