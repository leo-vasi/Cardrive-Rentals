package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    public enum Gender { M, F, O }
    public enum Status { ACTIVE, INACTIVE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @NotNull(message = "O gênero não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", nullable = false)
    private Gender gender = Gender.O;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Past(message = "A data de nascimento deve estar no passado")
    @Column(name = "user_birth_date", nullable = false)
    private LocalDate birthDate;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 números")
    @Column(name = "user_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 8, max = 255, message = "A senha deve ter entre 8 e 255 caracteres")
    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Contact contact;

    @Size(max = 255, message = "O caminho da foto deve ter no máximo 255 caracteres")
    @Column(name = "user_profile_picture", length = 255)
    private String userProfilePicture;

    @NotNull(message = "O status do usuário não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status status = Status.ACTIVE;

    @CreationTimestamp
    @Column(name = "user_created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "user_altered_at")
    private LocalDateTime alteredAt;
}

