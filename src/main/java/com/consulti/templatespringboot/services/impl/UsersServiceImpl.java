package com.consulti.templatespringboot.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.UsersValidations;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepository  userRepository;


    @Autowired
    UsersValidations usersValidations;


    @Override
    public List<UsersModel> listar() throws Exception {
      return userRepository.findAll();
    }


    @Override
    public UsersModel save(UsersModel newUser) throws Exception {
        try {
            return userRepository.save(newUser);
          } catch (Exception e) {
            throw new Exception(
              "Error al guardar el usuario: " + e.getMessage()
            );
          }
    }


    @Override
    public UsersModel update(UsersModel user) throws Exception {
        Optional<UsersModel> optional = userRepository.findById(
            (long) user.getId()
          );
          if (optional.isPresent()) {
            UsersModel existingUser = optional.get();

            existingUser.setEmail(user.getEmail());
        
            existingUser.setModifiedDate(user.getModifiedDate());
        
            existingUser.setModifiedBy(user.getModifiedBy());
         
            // Guardamos los cambios en la base de datos
            return userRepository.save(existingUser);
          } else {
            throw new Exception("No se encontró el registro a actualizar");
          }
    }


    @Override
    public Boolean delete(Long userId) throws Exception {
        try {
            userRepository.deleteById(userId);
            return true;
          } catch (Exception e) {
            throw new Exception(
              "Error borrando el usuario con id " +
              userId +
              ": " +
              e.getMessage()
            );
          }
        }
    }

