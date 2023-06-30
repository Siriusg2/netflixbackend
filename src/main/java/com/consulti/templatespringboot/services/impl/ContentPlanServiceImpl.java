package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.models.ContentPlanModel;
import com.consulti.templatespringboot.repositories.ContentPlanRepository;
import com.consulti.templatespringboot.repositories.ProfileRepository;
import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.ContentPlanService;
import com.consulti.templatespringboot.services.GetContentService;
import com.consulti.templatespringboot.utils.validations.UsersValidations;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentPlanServiceImpl implements ContentPlanService {

  @Autowired
  ContentPlanRepository contentPlanRepository;

  @Autowired
  UsersValidations usersValidations;

  @Autowired
  UserRepository userRepository;

  @Autowired
  GetContentService getContentService;

  @Autowired
  ProfileRepository profileRepository;

  @Override
  public List<String> getContent(String idAccount, String idProfile)
    throws Exception {
    Long parseIdUser = Long.parseLong(idAccount);
    List<ContentPlanModel> allContent = userRepository
      .findById(parseIdUser)
      .get()
      .getPlan()
      .getContent();

    Long parseIdProfile = Long.parseLong(idProfile);

    String dateOfBorn = profileRepository
      .findById(parseIdProfile)
      .get()
      .getDateOfBirth();

    Boolean isAdultOrChild = usersValidations.validationAge(dateOfBorn);

    if (!isAdultOrChild) {
      allContent =
        allContent
          .stream()
          .filter(content -> !content.getName().contains("adultos"))
          .collect(Collectors.toList());
    }

    List<String> endpoints = allContent
      .stream()
      .map(ContentPlanModel::getExternalEndpoint)
      .collect(Collectors.toList());

    return getContentService.fetchDataFromEndpoints(endpoints);
  }
}
