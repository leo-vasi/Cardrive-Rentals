package com.leo.cardriverental.repository;


import com.leo.cardriverental.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    List<PaymentMethod> findByCustomerId(Long customerId);

    List<PaymentMethod> findByPaymentType(String paymentType);

    List<PaymentMethod> findByCustomerIdAndPaymentStatus(Long customerId, PaymentMethod.PaymentStatus paymentStatus);

    boolean existsByIdAndCustomerId(Long paymentMethodId, Long customerId);
}
