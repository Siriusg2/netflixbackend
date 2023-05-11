package com.consulti.templatespringboot.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.*;



@Service
public interface RoleService  {

 
    List<RolesModel> listar() throws Exception;


    RolesModel save(RolesModel request) throws Exception;

    RolesModel update(RolesModel request) throws Exception;

    Boolean delete(Long request) throws Exception;
}
