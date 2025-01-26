package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    public enum Gender {
        M, F, O
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Size(max = 100)
    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(name = "user_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.O;

    @Column(name = "user_birth_date", nullable = false)
    private LocalDate birthDate;

    @Size(max = 11)
    @Column(name = "user_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Size(max = 15)
    @Column(name = "user_phone", nullable = false, length = 15)
    private String phone;

    @Size(max = 50)
    @Column(name = "user_email", unique = true, nullable = false, length = 50)
    private String email;

    @Size(max = 255)
    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Size(max = 255)
    @Column(name = "user_profile_picture", nullable = true, length = 255)
    private String userProfilePicture;

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
