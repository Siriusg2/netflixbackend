package com.consulti.templatespringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.consulti.templatespringboot.services.UsersService;
import com.consulti.templatespringboot.models.*;



@RestController
@RequestMapping("/users/")
public class UsersRest {
    
    @Autowired
    private UsersService usersService;

  
    }

    


