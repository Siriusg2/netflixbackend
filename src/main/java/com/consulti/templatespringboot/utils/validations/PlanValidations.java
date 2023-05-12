package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.PlanRepository;

@Component
public class PlanValidations {
    @Autowired
    PlanRepository   planRepository;


    public void nullIdValidation (Long idPlan) throws Exception{
        if(idPlan== null ){
            throw new Exception("Se debe ingresar el id del usuario");
        }
            }
}
