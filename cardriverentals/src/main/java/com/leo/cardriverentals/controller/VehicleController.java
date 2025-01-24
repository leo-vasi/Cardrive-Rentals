package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.dto.VehicleDTO;
import com.leo.cardriverentals.model.Vehicle;
import com.leo.cardriverentals.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vehicles);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<List<Vehicle>> getAllVehiclesDetails() {
        List<Vehicle> vehicles = vehicleService.getAllVehiclesDetails();
        if (vehicles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vehicles);
        }
    }
}
