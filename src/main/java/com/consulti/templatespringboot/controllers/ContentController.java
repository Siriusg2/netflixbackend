package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.services.ContentPlanService;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

  private final ContentPlanService contentPlanService;

  public ContentController(ContentPlanService contentPlanService) {
    this.contentPlanService = contentPlanService;
  }

  @PostMapping("/get")
  public ResponseEntity<List<Object>> getContent(
    @RequestBody Map<String, String> userData
  ) throws Exception {
    String userId = userData.get("userId");
    String profileId = userData.get("profileId");

    List<Object> response = contentPlanService.getContent(userId, profileId);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
