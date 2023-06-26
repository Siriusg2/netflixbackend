package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.models.PlanModel;
import com.consulti.templatespringboot.models.RolesModel;
import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.PlanRepository;
import com.consulti.templatespringboot.repositories.RoleRepository;
import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.UsersValidations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PlanRepository planRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  UsersValidations usersValidations;

  @Override
  public List<UsersModel> listar() throws Exception {
    return userRepository.findAll();
  }

  @Override
  public UsersModel save(
    String newUserEmail,
    String newUserPassword,
    String newUserDateBorn,
    String newUserPlan,
    String newUserRole
  ) throws Exception {
    if (newUserRole == null) {
      newUserRole = "2";
    }
    usersValidations.validationSave(
      newUserEmail,
      newUserPassword,
      newUserDateBorn,
      newUserPlan,
      newUserRole
    );

    UsersModel newUserData = new UsersModel();

    newUserData.setEmail(newUserEmail);
    newUserData.setPassword(newUserPassword);
    newUserData.setDateBorn(newUserDateBorn);

    Optional<PlanModel> userPlan = planRepository.findById(
      Long.parseLong(newUserPlan)
    );
    Optional<RolesModel> userRole = roleRepository.findById(
      Long.parseLong(newUserRole)
    );

    newUserData.setPlan(userPlan.get());
    newUserData.setRole(userRole.get());
    newUserData.setCreatedBy(newUserEmail);

    return userRepository.save(newUserData);
  }

  @Override
  public UsersModel update(
    Long userId,
    String newPassword,
    String newDateBorn,
    String newPlan,
    String newRole
  ) throws Exception {
    Optional<UsersModel> optional = userRepository.findById(userId);
    if (optional.isPresent()) {
      UsersModel existingUser = optional.get();

      if (newPassword != null) {
        existingUser.setPassword(newPassword);
      }

      if (newDateBorn != null) {
        existingUser.setDateBorn(newDateBorn);
      }
      if (newPlan != null) {
        Optional<PlanModel> newPlanUser = planRepository.findById(
          Long.parseLong(newPlan)
        );

        existingUser.setPlan(newPlanUser.get());
      }

      if (newRole != null) {
        Optional<RolesModel> newRoleUser = roleRepository.findById(
          Long.parseLong(newRole)
        );

        existingUser.setRole(newRoleUser.get());
      }

      existingUser.setModifiedBy(existingUser.getEmail());

      // Guardamos los cambios en la base de datos
      return userRepository.save(existingUser);
    } else {
      throw new Exception("No se encontró el usuario a actualizar");
    }
  }

  @Override
  public Boolean delete(Long userId) throws Exception {
    try {
      userRepository.deleteById(userId);
      return true;
    } catch (Exception e) {
      throw new Exception(
        "Error borrando el usuario con id " + userId + ": " + e.getMessage()
      );
    }
  }

  @Override
  public UsersModel findByEmail(String email) throws Exception {
    try {
      UsersModel user = userRepository.findByEmail(email);

      return user;
    } catch (Exception e) {
      throw new Exception(
        "No existe el usuario con el correo " + email + ": " + e.getMessage()
      );
    }
  }

  @Override
  public UsersModel login(String email, String password) throws Exception {
    usersValidations.loginValidation(email, password);

    UsersModel user = userRepository.findByEmail(email);

    return user;
  }
}
