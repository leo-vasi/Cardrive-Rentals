package com.leo.cardriverentals.repository;

import com.leo.cardriverentals.dto.VehicleDTO;
import com.leo.cardriverentals.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("""
        SELECT new com.leo.cardriverentals.dto.VehicleDTO(
            v.vehicleId, v.model, v.brand, v.year, v.licencePlate, v.vehicleCategory,
            v.color, v.availabilityStatus
        )
        FROM Vehicle v
    """)
    List<VehicleDTO> findAllVehicles();


}
