package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.CredentialHistory;
import com.leo.cardriverentals.repository.CredentialHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialHistoryService {

    private final CredentialHistoryRepository credentialHistoryRepository;

    @Autowired
    public CredentialHistoryService (CredentialHistoryRepository credentialHistoryRepository) {
        this.credentialHistoryRepository = credentialHistoryRepository;
    }

    public List<CredentialHistory> getAllCredentialHistories() {
        return credentialHistoryRepository.findAll();
    }

    public Optional<CredentialHistory> getCredentialHistoryById(Long id) {
        return credentialHistoryRepository.findById(id);
    }

    public CredentialHistory createCredentialHistory(CredentialHistory credentialHistory) {
        return credentialHistoryRepository.save(credentialHistory);
    }

    public CredentialHistory updateCredentialHistory(Long id, CredentialHistory credentialHistory) {
        CredentialHistory existingCredentialHistory = credentialHistoryRepository.findById(id).orElseThrow(()-> new RuntimeException("No Credential History Found"));
        existingCredentialHistory.setCustomer(credentialHistory.getCustomer());
        existingCredentialHistory.setNewEmail(credentialHistory.getNewEmail());
        existingCredentialHistory.setOldEmailHash(credentialHistory.getOldEmailHash());
        return credentialHistoryRepository.save(existingCredentialHistory);
    }

    public void deleteCredentialHistory(Long id) {
        credentialHistoryRepository.deleteById(id);
    }
}
