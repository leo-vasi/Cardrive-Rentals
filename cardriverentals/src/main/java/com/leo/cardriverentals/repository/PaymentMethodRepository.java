package com.leo.cardriverentals.repository;

import com.leo.cardriverentals.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository <PaymentMethod, Long> {
}
