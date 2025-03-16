package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.Rental;
import com.leo.cardriverentals.model.User;
import com.leo.cardriverentals.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController (RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        if (rentals.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(rentals);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        Optional<Rental> rental = rentalService.getRentalById(id);
        if (rental.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(rental.get());
        }
    }

    @PostMapping
    public ResponseEntity<Rental> createRental (@Valid @RequestBody Rental rental) {
        Rental createRental = rentalService.createRental(rental);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRental);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        Optional<Rental> existingRental = rentalService.getRentalById(id);
        if (existingRental.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Rental updateRental = rentalService.updateRental(id, rental);
            return ResponseEntity.ok(updateRental);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRental (@PathVariable Long id) {
        if (rentalService.getRentalById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            rentalService.deleteRental(id);
            return ResponseEntity.noContent().build();
        }
    }
}
