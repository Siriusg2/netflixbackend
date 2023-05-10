package com.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.PaymentRepository;

@Component
public class PaymentsValidations {
    @Autowired
    PaymentRepository   paymentRepository;
}
