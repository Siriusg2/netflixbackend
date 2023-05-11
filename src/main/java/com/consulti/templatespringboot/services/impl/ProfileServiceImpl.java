package com.consulti.templatespringboot.services.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.ProfileRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.ProfileValidations;

@Service
public class ProfileServiceImpl implements ProfileService {
    
    @Autowired 
    ProfileRepository   profileRepository;

    @Autowired
    ProfileValidations profileValidations;

    @Override
    public List<ProfilesModel> listar() throws Exception {
       return profileRepository.findAll();
    }

    @Override
    public ProfilesModel save(ProfilesModel request) throws Exception {
      try {
        return profileRepository.save(request);
      } catch (Exception e) {
        throw new Exception(
          "Error al guardar el perfil: " + e.getMessage()
        );
      }
    }

    @Override
    public ProfilesModel update(ProfilesModel profile) throws Exception {
      Optional<ProfilesModel> optional = profileRepository.findById(
        profile.getId()
      );
      if (optional.isPresent()) {
        ProfilesModel existingProfile = optional.get();
        existingProfile.setName(profile.getName());
    
        existingProfile.setModifiedDate(profile.getModifiedDate());
    
        existingProfile.setModifiedBy(profile.getModifiedBy());
     
        // Guardamos los cambios en la base de datos
        return profileRepository.save(existingProfile);
      } else {
        throw new Exception("No se encontró el registro a actualizar");
      }
    }

    @Override
  public Boolean delete(Long idProfile) throws Exception {
    try {
        profileRepository.deleteById(idProfile);
      return true;
    } catch (Exception e) {
      throw new Exception(
        "Error borrando el perfil con id " +
        idProfile +
        ": " +
        e.getMessage()
      );
    }
  }
}
