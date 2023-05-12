package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.models.ProfilesModel;
import com.consulti.templatespringboot.repositories.ProfileRepository;

@Component
public class ProfileValidations {
    
    @Autowired 
     ProfileRepository  profileRepository;

     
    public void saveProfileValidation (ProfilesModel newProfile) throws Exception{

String name = newProfile.getName();
        if(name != null ){
            throw new Exception("Se debe ingresar el id del usuario");
        }
            }
}
