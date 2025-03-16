package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Rental;
import com.leo.cardriverentals.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService (RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Long id, Rental rental) {
        Rental existingRental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental Not Found"));
        existingRental.setCustomer(rental.getCustomer());
        existingRental.setVehicle(rental.getVehicle());
        existingRental.setPaymentMethod(rental.getPaymentMethod());
        existingRental.setRentalStartDate(rental.getRentalStartDate());
        existingRental.setRentalEndDate(rental.getRentalEndDate());
        existingRental.setRentalStatus(rental.getRentalStatus());
        existingRental.setRentalTotal(rental.getRentalTotal());
        existingRental.setRentalPenalty(rental.getRentalPenalty());
        return rentalRepository.save(existingRental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
