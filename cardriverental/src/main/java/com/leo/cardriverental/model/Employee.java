package com.leo.cardriverental.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Employee extends User {

    public enum Role {
        ADMINISTRATOR, MANAGER, OPERATOR
    }

    @Column(name = "employee_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
