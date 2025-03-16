package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.RentalHistory;
import com.leo.cardriverentals.service.RentalHistoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<RentalHistory> getRentalHistoryById(@PathVariable Long id) {
        Optional<RentalHistory> rentalHistory = rentalHistoryService.getRentalHistoryById(id);
        return rentalHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RentalHistory> createRentalHistory(@Valid @RequestBody RentalHistory rentalHistory) {
        RentalHistory createdRentalHistory = rentalHistoryService.createRentalHistory(rentalHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRentalHistory);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<RentalHistory> updateRentalHistory(@PathVariable Long id, @Valid @RequestBody RentalHistory rentalHistory) {
        RentalHistory updatedRentalHistory = rentalHistoryService.updateRentalHistory(id, rentalHistory);
        return ResponseEntity.ok(updatedRentalHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalHistory(@PathVariable Long id) {
        rentalHistoryService.deleteRentalHistory(id);
        return ResponseEntity.noContent().build();
    }
}
