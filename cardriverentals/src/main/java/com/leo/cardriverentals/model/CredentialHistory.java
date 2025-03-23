package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credential_history")
public class CredentialHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @Column(name = "old_email_hash", nullable = false, length = 255)
    private String oldEmailHash;

    @Column(name = "new_email", nullable = false, length = 50)
    private String newEmail;

    @Column(name = "changed_at", nullable = false)
    private Instant changedAt;
}

