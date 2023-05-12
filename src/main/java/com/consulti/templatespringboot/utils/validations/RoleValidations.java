package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.RoleRepository;

@Component
public class RoleValidations {
    
@Autowired
RoleRepository roleRepository;


public void nullIdValidation (Long idRole) throws Exception{
    if(idRole== null ){
        throw new Exception("Se debe ingresar el id del usuario");
    }
        }
}
