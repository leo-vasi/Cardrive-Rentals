package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.Rental;
import com.leo.cardriverentals.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
