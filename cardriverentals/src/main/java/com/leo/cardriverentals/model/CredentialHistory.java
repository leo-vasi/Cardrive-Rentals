package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "O hash do e-mail antigo não pode estar em branco")
    @Size(max = 255, message = "O hash do e-mail antigo deve ter no máximo 255 caracteres")
    private String oldEmailHash;

    @Column(name = "new_email", nullable = false, length = 50)
    @NotBlank(message = "O novo e-mail não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 50, message = "O novo e-mail deve ter no máximo 50 caracteres")
    private String newEmail;

    @Column(name = "changed_at", nullable = false)
    @NotNull(message = "A data da alteração é obrigatória")
    private Instant changedAt;
}

