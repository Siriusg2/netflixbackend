package com.consulti.templatespringboot.services;

import com.consulti.templatespringboot.models.ContentPlanModel;

public interface ContentPlanService {
  public ContentPlanModel saveContentPlan(String name, String externalEndpoint)
    throws Exception;

  public ContentPlanModel updateContenPlan(
    String name,
    String externalEndpoint
  ) throws Exception;

  public Boolean deleteContentPlan(Long contentPlanId) throws Exception;
}
