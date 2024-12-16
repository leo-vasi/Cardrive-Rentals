package com.leo.repository;

import com.leo.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    List<PaymentMethod> findByCustomerId(Long customerId);

    List<PaymentMethod> findByPaymentType(String paymentType);

    List<PaymentMethod> findByCustomerIdAndPaymentStatus(Long customerId, String paymentStatus);

    boolean existsByIdAndCustomerId(Long paymentMethodId, Long customerId);
}
