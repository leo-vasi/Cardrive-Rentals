package com.leo.repository;

import com.leo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByAvailabilityStatus(String availabilityStatus);

    List<Vehicle> findByCategory(String category);

    List<Vehicle> findByBrandModel(String brand, String model);

    List<Vehicle> findByPricePerDayBetween(Double minPrice, Double maxPrice);

    List<Vehicle> findByAvailabilityStatusAndPricePerDayBetween(String availabilityStatus, Double minPrice, Double maxPrice);

    List<Vehicle> findByModelContainingIgnoreCase(String model);
}
