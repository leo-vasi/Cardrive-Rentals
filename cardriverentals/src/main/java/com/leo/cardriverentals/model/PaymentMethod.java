package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    public enum PaymentType {
        CREDIT_CARD, DEBIT_CARD, PAYPAL, PIX
    }

    public enum PaymentStatus {
        ACTIVE, INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private Long paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Size(max = 16)
    @Column(name = "card_number", nullable = true, length = 16)
    private String cardNumber;

    @Size(max = 100)
    @Column(name = "card_holder_name", nullable = true, length = 100)
    private String cardHolderName;

    @Size(max = 5)
    @Column(name = "card_expiry_date", nullable = true, length = 5)
    private String cardExpiryDate;

    @Size(max = 3)
    @Column(name = "card_cvv", nullable = true, length = 3)
    private String cardCvv;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "payment_created_at", updatable = false)
    private LocalDateTime paymentCreatedAt;

    @UpdateTimestamp
    @Column(name = "payment_altered_at")
    private LocalDateTime paymentAlteredAt;
}

