package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.services.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private UsersService usersService;

  @GetMapping("/all")
  public List<UsersModel> getAllUsers() throws Exception {
    return usersService.listar();
  }

  @DeleteMapping("delete/{userId}")
  public ResponseEntity <Boolean> deleteUser(@PathVariable Long userId) throws Exception {
    

    
      return ResponseEntity.status(HttpStatus.OK).body(usersService.delete(userId));
  


   
  }

  @PostMapping("/save_user")
  public ResponseEntity<UsersModel> saveUser(@RequestBody UsersModel usersModel) throws Exception {

      UsersModel savedUser = usersService.save(usersModel);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
   
  }

  @PutMapping("/update-user")
  public ResponseEntity<UsersModel> updateUser(

    @RequestBody UsersModel userDetails
  ) throws Exception {
    UsersModel updatedUser = usersService.update( userDetails);
    return ResponseEntity.ok(updatedUser);
  }
}
