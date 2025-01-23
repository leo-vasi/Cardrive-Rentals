package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(name = "user_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.O;

    @Column(name = "user_birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "user_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "user_phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "user_email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_profile_picture", nullable = true, length = 255)
    private String userProfilePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status status = Status.ACTIVE;

    @Column(name = "user_created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "user_altered_at", insertable = false)
    private LocalDateTime alteredAt;

}
