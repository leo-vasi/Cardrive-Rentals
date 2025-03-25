package com.leo.cardriverentals.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @NotBlank(message = "O telefone não pode estar em branco")
    @Pattern(regexp = "\\d{10,15}", message = "O telefone deve ter entre 10 e 15 números")
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 50, message = "O e-mail deve ter no máximo 50 caracteres")
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Email(message = "Formato de e-mail de recuperação inválido")
    @Size(max = 50, message = "O e-mail de recuperação deve ter no máximo 50 caracteres")
    @Column(name = "recovery_email", length = 50)
    private String recoveryEmail;
}
