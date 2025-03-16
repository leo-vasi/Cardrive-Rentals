package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.RentalHistory;
import com.leo.cardriverentals.repository.RentalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalHistoryService {

    private final RentalHistoryRepository rentalHistoryRepository;

    @Autowired
    public RentalHistoryService(RentalHistoryRepository rentalHistoryRepository) {
        this.rentalHistoryRepository = rentalHistoryRepository;
    }

    public List<RentalHistory> getRentalHistory() {
        return rentalHistoryRepository.findAll();
    }

    public Optional<RentalHistory> getRentalHistoryById(Long id) {
        return rentalHistoryRepository.findById(id);
    }

    public RentalHistory createRentalHistory(RentalHistory rentalHistory) {
        return rentalHistoryRepository.save(rentalHistory);
    }

    public RentalHistory updateRentalHistory(Long id, RentalHistory rentalHistory) {
        RentalHistory existingRentalHistory = rentalHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("RentalHistory Not Found"));
        existingRentalHistory.setCustomer(rentalHistory.getCustomer());
        existingRentalHistory.setRentalDate(rentalHistory.getRentalDate());
        existingRentalHistory.setReturnDate(rentalHistory.getReturnDate());
        existingRentalHistory.setVehicle(rentalHistory.getVehicle());
        existingRentalHistory.setStatus(rentalHistory.getStatus());
        return rentalHistoryRepository.save(existingRentalHistory);
    }

    public void deleteRentalHistory(Long id) {
        rentalHistoryRepository.deleteById(id);
    }
}

