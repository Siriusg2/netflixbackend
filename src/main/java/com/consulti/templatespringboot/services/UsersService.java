package com.consulti.templatespringboot.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.UsersModel;



@Service
public interface UsersService {

    List<UsersModel> listar() throws Exception;


    UsersModel save(UsersModel request) throws Exception;

    UsersModel update(UsersModel request) throws Exception;

    Boolean delete(Long request) throws Exception;
}
