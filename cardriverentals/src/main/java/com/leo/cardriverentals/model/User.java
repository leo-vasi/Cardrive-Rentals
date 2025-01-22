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

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status status = Status.ACTIVE;

    @Column(name = "user_created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "user_altered_at", insertable = false)
    private LocalDateTime alteredAt;


    /*public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getAlteredAt() {
        return alteredAt;
    }

    public void setAlteredAt(LocalDateTime alteredAt) {
        this.alteredAt = alteredAt;
    }

     */
}
