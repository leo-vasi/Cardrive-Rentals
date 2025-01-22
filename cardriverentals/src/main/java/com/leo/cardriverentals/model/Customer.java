package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer extends User {

}
