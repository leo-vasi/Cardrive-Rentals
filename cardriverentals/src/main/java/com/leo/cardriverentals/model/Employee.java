package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends User {

    @Column(name = "employee_salary", columnDefinition = "DECIMAL(10,2) DEFAULT 0.00", nullable = false)
    private Double salary = 0.00;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private Role role;
}
