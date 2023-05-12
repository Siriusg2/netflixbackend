package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.ProfileRepository;

@Component
public class ProfileValidations {
    
    @Autowired 
     ProfileRepository  profileRepository;

     
    public void nullIdValidation (Long idProfile) throws Exception{
        if(idProfile== null ){
            throw new Exception("Se debe ingresar el id del usuario");
        }
            }
}
