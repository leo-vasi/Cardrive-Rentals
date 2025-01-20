package com.leo.cardriverental.repository;


import com.leo.cardriverental.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByAvailabilityStatus(Vehicle.AvailabilityStatus availabilityStatus);

    List<Vehicle> findByCategory(String category);

    List<Vehicle> findByBrandAndModel(String brand, String model);

    List<Vehicle> findByPricePerDayBetween(Double minPrice, Double maxPrice);

    List<Vehicle> findByAvailabilityStatusAndPricePerDayBetween(Vehicle.AvailabilityStatus availabilityStatus, Double minPrice, Double maxPrice);

    List<Vehicle> findByModelContainingIgnoreCase(String model);
}
