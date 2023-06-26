package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.models.ProfilesModel;
import com.consulti.templatespringboot.services.ProfileService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

  @Autowired
  ProfileService profileService;

  @GetMapping("/all")
  public List<ProfilesModel> getAllProfiles() throws Exception {
    return profileService.listar();
  }

  @DeleteMapping("delete/{profileId}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable Long profileId)
    throws Exception {
    return ResponseEntity.status(HttpStatus.OK).body(true);
  }

  @PostMapping("/save-profile")
  public ResponseEntity<ProfilesModel> savePayment(
    @RequestBody Map<String, String> newProfile
  ) throws Exception {
    Long userId = Long.parseLong(newProfile.get("idCreator"));
    String name = newProfile.get("name");
    String dateBorn = newProfile.get("dateBorn");

    ProfilesModel savedProfile = profileService.save(userId, name, dateBorn);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedProfile);
  }

  @PutMapping("/update-profile")
  public ResponseEntity<ProfilesModel> updateUser(
    @RequestBody ProfilesModel profileDetails
  ) throws Exception {
    ProfilesModel updatedProfile = profileService.update(profileDetails);
    return ResponseEntity.ok(updatedProfile);
  }
}
