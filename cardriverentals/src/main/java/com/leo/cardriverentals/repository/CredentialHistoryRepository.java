package com.leo.cardriverentals.repository;

import com.leo.cardriverentals.model.CredentialHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialHistoryRepository extends JpaRepository<CredentialHistory, Long> {
}
