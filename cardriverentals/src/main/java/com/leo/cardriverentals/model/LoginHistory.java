package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login_history")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long loginHistoryId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "old_email", nullable = false, length = 50)
    private String oldEmail;

    @Column(name = "new_email", nullable = false, length = 50)
    private String newEmail;

    @Column(name = "old_password_hash", nullable = false, length = 255)
    private String oldPassword;

    @Column(name = "new_password_hash", nullable = false, length = 255)
    private String newPassword;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;
}
