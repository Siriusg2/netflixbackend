package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.services.UsersService;
import java.util.List;
import java.util.Map;
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
  @ResponseBody
  public ResponseEntity<List<UsersModel>> getAllUsers() throws Exception {
    List<UsersModel> users = usersService.listar();
    return ResponseEntity.ok().body(users);
  }

  @DeleteMapping("delete/{userId}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId)
    throws Exception {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(usersService.delete(userId));
  }

  @PostMapping("/save-user")
  public ResponseEntity<UsersModel> saveUser(
    @RequestBody Map<String, String> userData
  ) throws Exception {
    String newUserEmail = userData.get("email");
    String newUserPassword = userData.get("password");
    String newUserDateBorn = userData.get("dateBorn");
    String newUserPlan = userData.get("plan");
    String newUserRole = userData.get("role");

    UsersModel savedUser = usersService.save(
      newUserEmail,
      newUserPassword,
      newUserDateBorn,
      newUserPlan,
      newUserRole
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }

  @PutMapping("/update-user/{userId}")
  public ResponseEntity<UsersModel> updateUser(
    @RequestBody Map<String, String> newDataUser,
    @PathVariable Long userId
  ) throws Exception {
    String newUserPassword = newDataUser.get("password");
    String newUserDateBorn = newDataUser.get("dateBorn");
    String newUserPlan = newDataUser.get("plan");
    String newUserRole = newDataUser.get("role");

    UsersModel updatedUser = usersService.update(
      userId,
      newUserPassword,
      newUserDateBorn,
      newUserPlan,
      newUserRole
    );
    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
  }
}
