package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.PaymentMethod;
import com.leo.cardriverentals.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
