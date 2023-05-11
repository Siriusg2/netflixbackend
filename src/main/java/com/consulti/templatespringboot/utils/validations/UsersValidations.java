package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.repositories.UserRepository;

@Component
public class UsersValidations {
    
    @Autowired 
    UserRepository userRepository ;
}
