package com.leo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class User {

    public enum Gender {
        M, F, O
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "user_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "user_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "user_phone", nullable = true, length = 15)
    private String phone;

    @Column(name = "user_email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_status", nullable = false)
    private Status status;

}
