package com.consulti.templatespringboot.services;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ContentPlanService {
  public List<String> getContent(String idAccount, String ageProfile)
    throws Exception;
}
