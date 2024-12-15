package com.leo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends User{

    public enum Role {
        ADMINISTRATOR, MANAGER, OPERATOR
    }

    @Column(name = "employee_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "handledBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> handledRentals;
}
