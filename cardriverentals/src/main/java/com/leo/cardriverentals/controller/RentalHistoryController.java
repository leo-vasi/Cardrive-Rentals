package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.RentalHistory;
import com.leo.cardriverentals.service.RentalHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentalhistory")
public class RentalHistoryController {

    private final RentalHistoryService rentalHistoryService;

    public RentalHistoryController(RentalHistoryService rentalHistoryService) {
        this.rentalHistoryService = rentalHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<RentalHistory>> getRentalHistory() {
        List<RentalHistory> rentalHistories = rentalHistoryService.getRentalHistory();
        if (rentalHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(rentalHistories);
        }
    }
}
