package com.consulti.templatespringboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.repositories.PaymentRepository;
import com.consulti.templatespringboot.services.*;

@Service
public class PaymentsServiceImpl  implements PaymentsService {
    
    @Autowired 
    PaymentRepository paymentRepository;


}
