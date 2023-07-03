package com.consulti.templatespringboot.controllers;

import com.consulti.templatespringboot.services.ContentPlanService;
import com.consulti.templatespringboot.utils.DTO.FilmDTo;
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
  public ResponseEntity<List<FilmDTo>> getContent(
    @RequestBody Map<String, String> userData
  ) throws Exception {
    String userId = userData.get("userId");
    String profileId = userData.get("profileId");

    List<FilmDTo> response = contentPlanService.getContent(userId, profileId);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
