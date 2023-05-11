package com.consulti.templatespringboot.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.RolesModel;
import com.consulti.templatespringboot.repositories.RoleRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.RoleValidations;



@Service
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    RoleRepository  roleRepository;

    @Autowired
    RoleValidations   roleValidations;

    @Override
    public List<RolesModel> listar() throws Exception {
        return roleRepository.findAll();
    }

    @Override
    public RolesModel save(RolesModel role) throws Exception {
        try {
            return roleRepository.save(role);
          } catch (Exception e) {
            throw new Exception(
              "Error al guardar el rol: " + e.getMessage()
            );
          }
    }

    @Override
    public RolesModel update(RolesModel role) throws Exception {
        Optional<RolesModel> optional = roleRepository.findById(
            role.getId()
          );
          if (optional.isPresent()) {
            RolesModel existingRole = optional.get();
            existingRole.setName(role.getName());
        
            existingRole.setModifiedDate(role.getModifiedDate());
        
            existingRole.setModifiedBy(role.getModifiedBy());
         
            // Guardamos los cambios en la base de datos
            return roleRepository.save(existingRole);
          } else {
            throw new Exception("No se encontró el registro a actualizar");
          }
    }

    @Override
    public Boolean delete(Long roleId) throws Exception {
        try {
            roleRepository.deleteById(roleId);
            return true;
          } catch (Exception e) {
            throw new Exception(
              "Error deleting payment with id " +
              roleId +
              ": " +
              e.getMessage()
            );
          }
        }
    }

