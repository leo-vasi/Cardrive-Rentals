package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends User {

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private Role role;
}
