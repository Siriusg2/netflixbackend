package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.ProfileRepository;
import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.ProfileValidations;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  ProfileRepository profileRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ProfileValidations profileValidations;

  @Override
  public List<ProfilesModel> listar() throws Exception {
    return profileRepository.findAll();
  }

  @Override
  public ProfilesModel save(Long userId, String name, String dateBorn)
    throws Exception {
    try {
      UsersModel creator = userRepository.findById(userId).get();

      ProfilesModel newProfile = new ProfilesModel();
      if (creator != null) {
        newProfile.setName(name);
        newProfile.setDateOfBirth(dateBorn);
        newProfile.setUser(creator);
        newProfile.setCreatedBy(creator.getEmail());
      }
      return profileRepository.save(newProfile);
       
    } catch (Exception e) {
      throw new Exception("Error al guardar el perfil: " + e.getMessage());
    }
  }

  @Override
  public ProfilesModel update(ProfilesModel profile) throws Exception {
    ProfilesModel existingProfile = profileRepository
      .findById(profile.getId())
      .get();
    if (existingProfile != null) {
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
        "Error borrando el perfil con id " + idProfile + ": " + e.getMessage()
      );
    }
  }
}
