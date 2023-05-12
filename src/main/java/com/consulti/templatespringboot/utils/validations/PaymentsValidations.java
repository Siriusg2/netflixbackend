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
if(idPayment== null ){
    throw new Exception("Se debe ingresar el id del usuario");
}
    }
//     public void newPaymentValidation (PaymentsModel newPayment) throws Exception{
//         PaymentsModel objNull = new PaymentsModel();
//         PaymentsModel request =  newPayment;

//         String creator = newPayment.getCreatedBy();
//         UsersModel user = newPayment.getUser();
     

// if(newPayment== objNull ){
//     throw new Exception("Debes ingresar los datos del pago");
// }

// if(creator==null){

// }
//     }
    
}
