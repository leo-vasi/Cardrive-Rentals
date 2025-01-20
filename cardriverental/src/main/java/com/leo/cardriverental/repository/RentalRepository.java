package com.leo.cardriverental.repository;


import com.leo.cardriverental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findRentalByStatus (Rental.RentalStatus rentalStatus);

    List<Rental> findCustomerById(Long customerId);

    List<Rental> findVehicleId(Long vehicleId);

    List<Rental> findByRentalStartDateBetween(LocalDate rentalStartDate, LocalDate rentalEndDate);

    List<Rental> findByVehicleIdAndRentalStatus(Long vehicleId, String rentalStatus);

    List<Rental> findByCustomerIdAndRentalStatus(Long customerId, String rentalStatus);

    List<Rental> findByRentalStartDateOrRentalEndDate(LocalDate rentalStartDate, LocalDate rentalEndDate);

}
