package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.UserRepository;

@Component
public class UsersValidations {
    
    @Autowired 
    UserRepository userRepository ;

    public Boolean validationSave (UsersModel newUser) throws Exception{
    
      
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            throw new Exception("El campo email no debe estar vacio");
        }
        
        if(!newUser.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new Exception("El campo email debe tener formato de correo electronico ej: alguien@algo.com");
        }

        if(!newUser.getDate_born().matches("\\d{4}-\\d{2}-\\d{2}")){
            throw new Exception("El campo fecha de nacimiento debe tener el formato: yyyy-MM-dd");
        }
        if (newUser.getPassword() == null || newUser.getPassword().isEmpty()) {
          throw new Exception("El campo password no debe estar vacio");
        }
        if (newUser.getDate_born() == null || newUser.getDate_born().isEmpty()) {
        throw new Exception("El campo fecha de nacimiento no debe estar vacio");
        }
        if (newUser.getRole() == null) {
            throw new Exception("El campo rol no debe estar vacio");
        }
        if (newUser.getPlan() == null) {
           throw new Exception("El campo email no debe estar vacio");
        }
 return true;

            }
}
