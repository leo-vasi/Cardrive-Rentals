package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.PaymentMethod;
import com.leo.cardriverentals.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod (Long id, PaymentMethod paymentMethod) {
        PaymentMethod existingPaymentMethod = paymentMethodRepository.findById(id).orElseThrow(()-> new RuntimeException("Rental Not Found"));
        existingPaymentMethod.setUser(paymentMethod.getUser());
        existingPaymentMethod.setAddress(paymentMethod.getAddress());
        existingPaymentMethod.setPaymentType(paymentMethod.getPaymentType());
        existingPaymentMethod.setCardNumber(paymentMethod.getCardNumber());
        existingPaymentMethod.setCardHolderName(paymentMethod.getCardHolderName());
        existingPaymentMethod.setCardExpiryDate(paymentMethod.getCardExpiryDate());
        existingPaymentMethod.setCardCvv(paymentMethod.getCardCvv());
        existingPaymentMethod.setPaymentStatus(paymentMethod.getPaymentStatus());
        return paymentMethodRepository.save(existingPaymentMethod);
    }

    public void deletePaymentMethod (Long id) {
        paymentMethodRepository.deleteById(id);
    }
}
