package com.consulti.templatespringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.consulti.templatespringboot.models.RolesModel;
import com.consulti.templatespringboot.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
    
    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public List<RolesModel> getAllRoles() throws Exception {
      return roleService.listar();
    }
  
    @DeleteMapping("delete/{roleId}")
    public ResponseEntity <Boolean> deleteUser(@PathVariable Long roleId) throws Exception {
      
      return ResponseEntity.status(HttpStatus.OK).body(true);
    }
  
    @PostMapping("/save-role")
    public ResponseEntity<RolesModel> savePayment(@RequestBody RolesModel newRole) throws Exception {
  
        RolesModel savedRole = roleService.save(newRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
     
    }
  
    @PutMapping("/update-role")
    public ResponseEntity<RolesModel> updateUser(
  
      @RequestBody RolesModel roleDetails
    ) throws Exception {
        RolesModel updatedRole = roleService.update( roleDetails);
      return ResponseEntity.ok(updatedRole);
    }
}
