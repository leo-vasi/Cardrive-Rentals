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

    public RentalHistory saveRentalHistory(RentalHistory rentalHistory) {
        return rentalHistoryRepository.save(rentalHistory);
    }
}

