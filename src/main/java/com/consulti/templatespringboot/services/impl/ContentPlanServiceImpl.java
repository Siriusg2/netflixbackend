package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.models.ContentPlanModel;
import com.consulti.templatespringboot.repositories.ContentPlanRepository;
import com.consulti.templatespringboot.services.ContentPlanService;
import com.consulti.templatespringboot.utils.validations.ContentPlanValidations;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentPlanServiceImpl implements ContentPlanService {

  @Autowired
  ContentPlanRepository contentPlanRepository;

  @Autowired
  ContentPlanValidations contentPlanValidations;

  @Override
  public ContentPlanModel saveContentPlan(String name, String externalEndpoint)
    throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'saveContentPlan'"
    );
  }

  @Override
  public ContentPlanModel updateContenPlan(
    String name,
    String externalEndpoint
  ) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'updateContenPlan'"
    );
  }

  @Override
  public Boolean deleteContentPlan(Long contentPlanId) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteContentPlan'"
    );
  }
}
