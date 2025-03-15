package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.dto.VehicleDTO;
import com.leo.cardriverentals.model.Vehicle;
import com.leo.cardriverentals.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        if (vehicle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(vehicle.get());
        }
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle (@Valid @RequestBody Vehicle vehicle) {
        Vehicle createVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createVehicle);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> existingVehicle = vehicleService.getVehicleById(id);
        if (existingVehicle.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Vehicle updateVehicle = vehicleService.updateVehicle(id, vehicle);
            return ResponseEntity.ok(updateVehicle);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        if (vehicleService.getVehicleById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.noContent().build();
        }
    }


}
