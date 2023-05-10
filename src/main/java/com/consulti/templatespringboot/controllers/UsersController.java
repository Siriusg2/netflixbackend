package com.consulti.templatespringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.consulti.templatespringboot.services.UsersService;




@RestController
@RequestMapping("/users/")
public class UsersController {
    
    @Autowired
    private UsersService usersService;

  
    }

    


