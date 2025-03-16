package com.leo.cardriverentals.controller;


import com.leo.cardriverentals.model.PaymentMethod;
import com.leo.cardriverentals.model.Rental;
import com.leo.cardriverentals.service.PaymentMethodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paymentmethods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
        if (paymentMethods.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(paymentMethods);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById (@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethod = paymentMethodService.getPaymentMethodById(id);
        if (paymentMethod.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(paymentMethod.get());
        }
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> createPaymentMethod (@Valid @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod createPaymentMethod = paymentMethodService.createPaymentMethod(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPaymentMethod);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod (@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        Optional<PaymentMethod> existingPaymentMethod = paymentMethodService.getPaymentMethodById(id);
        if (existingPaymentMethod.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            PaymentMethod updatePaymentMethod = paymentMethodService.updatePaymentMethod(id, paymentMethod);
            return ResponseEntity.ok(paymentMethod);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaymentMethod (@PathVariable Long id) {
        if (paymentMethodService.getPaymentMethodById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            paymentMethodService.deletePaymentMethod(id);
            return ResponseEntity.noContent().build();
        }
    }
}
