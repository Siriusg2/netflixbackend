package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.PaymentRepository;


@Component
public class PaymentsValidations {
    @Autowired
    PaymentRepository   paymentRepository;

    public void nullIdValidation (Long idUser) throws Exception{
if(idUser== null ){
    throw new Exception("Se debe ingresar el id del usuario");
}
    }
}
