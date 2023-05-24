package com.consulti.templatespringboot.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulti.templatespringboot.models.RolesModel;
import com.consulti.templatespringboot.repositories.RoleRepository;

@Component
public class RoleValidations {
    
@Autowired
RoleRepository roleRepository;


public Boolean validateSaveRole (RolesModel newRole) throws Exception{

    RolesModel existingRole = roleRepository.findByName(newRole.getName());

    if(existingRole.getName().equals(newRole.getName()) ){
        throw new Exception("Ya existe un rol con ese nombre");
}
    if(newRole.getName().isEmpty() || newRole.getName() == null){
        throw new Exception("se debe ingresar el nombre del nuevo rol");
}


return true;
}
public Boolean validateSaveRolePerUser (RolesModel newRole) throws Exception{

    RolesModel existingRole = roleRepository.findByName(newRole.getName());

    if(existingRole.getName().equals(newRole.getName()) ){
        throw new Exception("Ya existe un rol con ese nombre");
}
    if(newRole.getName().isEmpty() || newRole.getName() == null){
        throw new Exception("se debe ingresar el nombre del nuevo rol");
}


return true;
}

}