package com.consulti.templatespringboot.utils.validations;

import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.UserRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersValidations {

  @Autowired
  UserRepository userRepository;

  public void validationSave(
    String newUserEmail,
    String newUserPassword,
    String newUserDateBorn,
    String newUserPlan,
    String newUserRole
  ) throws Exception {
    UsersModel existingUser = userRepository.findByEmail(newUserEmail);

    if (existingUser != null) {
      throw new Exception("Ya existe una cuenta con ese correo electrónico");
    }
    if (
      !newUserEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    ) {
      throw new Exception(
        "El campo email debe tener formato de correo electronico ej: alguien@algo.com"
      );
    }

    if (!newUserDateBorn.matches("\\d{4}-\\d{2}-\\d{2}")) {
      throw new Exception(
        "El campo fecha de nacimiento debe tener el formato: yyyy-MM-dd"
      );
    }
  }

  public Boolean validationAge(String userDateBorn) throws Exception {
    try {
      String date = userDateBorn;
      LocalDate dateBorn = LocalDate.parse(date);

      long edad = ChronoUnit.YEARS.between(dateBorn, LocalDate.now());

      if (edad >= 18) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      throw new Exception(
        "No es posible parsear el dato de la fecha al tipo de dato LocalDate"
      );
    }
  }

  public void loginValidation(String email, String password) throws Exception {
    UsersModel user = userRepository.findByEmail(email);

    if (user == null) {
      throw new Exception("No existe un usuario con registrado con ese email");
    }

    if (!user.getPassword().equals(password)) {
      throw new Exception("La contraseña es incorrecta");
    }
  }
}
