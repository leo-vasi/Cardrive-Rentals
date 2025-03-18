package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.CredentialHistory;
import com.leo.cardriverentals.service.CredentialHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credentialhistory")
public class CredentialHistoryController {

    private final CredentialHistoryService credentialHistoryService;

    public CredentialHistoryController (CredentialHistoryService credentialHistoryService) {
        this.credentialHistoryService = credentialHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<CredentialHistory>> getAllCredentialHistories () {
        List<CredentialHistory> credentialHistories = credentialHistoryService.getAllCredentialHistories();
        if (credentialHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(credentialHistories);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CredentialHistory> getCredentialHistoryById (@PathVariable Long id) {
        Optional<CredentialHistory> credentialHistory = credentialHistoryService.getCredentialHistoryById(id);
        if (credentialHistory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(credentialHistory.get());
        }
    }

    @PostMapping
    public ResponseEntity<CredentialHistory> createCredentialHistory (@RequestBody CredentialHistory credentialHistory) {
        CredentialHistory createdCredentialHistory = credentialHistoryService.createCredentialHistory(credentialHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCredentialHistory);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<CredentialHistory> updateCredentialHistory (@PathVariable Long id, @RequestBody CredentialHistory credentialHistory) {
        Optional<CredentialHistory> existingCredentialHistory = credentialHistoryService.getCredentialHistoryById(id);
        if (existingCredentialHistory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            CredentialHistory updatedCredentialHistory = credentialHistoryService.updateCredentialHistory(id, credentialHistory);
            return ResponseEntity.ok(credentialHistory);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCredentialHistoryy (@PathVariable Long id) {
        if (credentialHistoryService.getCredentialHistoryById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            credentialHistoryService.deleteCredentialHistory(id);
            return ResponseEntity.noContent().build();
        }
    }
}
