package com.leo.cardriverentals.service;

import com.leo.cardriverentals.dto.VehicleDTO;
import com.leo.cardriverentals.model.Vehicle;
import com.leo.cardriverentals.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    public List<Vehicle> getAllVehiclesDetails() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehcile = vehicleRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehicle Not Found"));
        existingVehcile.setModel(vehicle.getModel());
        existingVehcile.setBrand(vehicle.getBrand());
        existingVehcile.setYear(vehicle.getYear());
        existingVehcile.setLicencePlate(vehicle.getLicencePlate());
        existingVehcile.setVehicleCategory(vehicle.getVehicleCategory());
        existingVehcile.setColor(vehicle.getColor());
        existingVehcile.setAvailabilityStatus(vehicle.getAvailabilityStatus());
        return vehicleRepository.save(existingVehcile);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }


}
