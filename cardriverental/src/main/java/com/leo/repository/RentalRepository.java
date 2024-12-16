package com.leo.repository;

import com.leo.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findRentalByStatus (String rentalStatus);

    List<Rental> findCustomerById(Long customerId);

    List<Rental> findVehicleId(Long vehicleId);

    List<Rental> findByRentalStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<Rental> findByVehicleIdAndRentalStatus(Long vehicleId, String rentalStatus);

    List<Rental> findByCustomerIdAndRentalStatus(Long customerId, String rentalStatus);

    List<Rental> findByRentalStartDateOrRentalEndDate(LocalDate startDate, LocalDate endDate);

}
