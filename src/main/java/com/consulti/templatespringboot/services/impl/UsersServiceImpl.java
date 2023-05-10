package com.consulti.templatespringboot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.*;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepository  userRepository;
}
