package com.consulti.templatespringboot.utils.validations;

import com.consulti.templatespringboot.models.PlanModel;
import com.consulti.templatespringboot.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanValidations {

  @Autowired
  PlanRepository planRepository;

  public void nullContentAndNameValidation(PlanModel planData)
    throws Exception {}
}
