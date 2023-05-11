package com.consulti.templatespringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.consulti.templatespringboot.models.ProfilesModel;
import com.consulti.templatespringboot.services.ProfileService;

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
    public ResponseEntity <Boolean> deleteUser(@PathVariable Long profileId) throws Exception {
      
      return ResponseEntity.status(HttpStatus.OK).body(true);
    }
  
    @PostMapping("/save-profile")
    public ResponseEntity<ProfilesModel> savePayment(@RequestBody ProfilesModel newProfile) throws Exception {
  
        ProfilesModel savedProfile = profileService.save(newProfile);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfile);
     
    }
  
    @PutMapping("/update-profile")
    public ResponseEntity<ProfilesModel> updateUser(
  
      @RequestBody ProfilesModel profileDetails
    ) throws Exception {
        ProfilesModel updatedProfile = profileService.update( profileDetails);
      return ResponseEntity.ok(updatedProfile);
    }
}
