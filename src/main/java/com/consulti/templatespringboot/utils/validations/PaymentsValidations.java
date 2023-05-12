package com.consulti.templatespringboot.utils.validations;

import java.util.Optional;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.models.PaymentsModel;
import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.PaymentRepository;





@Component
public class PaymentsValidations {
    @Autowired
    PaymentRepository   paymentRepository;

    public void nullIdValidation (Long idPayment) throws Exception{

        
    }
    
}
