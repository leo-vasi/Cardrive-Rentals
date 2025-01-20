package com.leo.cardriverental.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment_methods")
public class PaymentMethod {

    public enum PaymentType {
        CREDIT_CARD, DEBIT_CARD, PIX, PAYPAL
    }

    public enum PaymentStatus {
        ACTIVE, INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @Column(name = "card_holder_name", length = 100)
    private String cardHolder;

    @Column(name = "card_expiry_date", length = 5)
    private String cardExpiryDate;

    @Column(name = "card_cvv", length = 3)
    private String cardCvv;

    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.ACTIVE;

    @Column(name = "payment_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "payment_altered_at")
    private LocalDateTime alteredAt;

    @PreUpdate
    public void updateTimestamp() {
        this.alteredAt = LocalDateTime.now();
    }
}
