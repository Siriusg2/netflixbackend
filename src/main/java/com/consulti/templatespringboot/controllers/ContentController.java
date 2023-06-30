package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.services.ContentPlanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

  @Autowired
  ContentPlanService contentPlanService;

  @PostMapping("/get")
  public ResponseEntity<List<String>> getContent(
    @RequestBody Map<String, String> userData
  ) throws Exception {
    String userId = userData.get("userId");
    String profileId = userData.get("profileId");

    return ResponseEntity
      .status(HttpStatus.OK)
      .body(contentPlanService.getContent(userId, profileId));
  }
}
