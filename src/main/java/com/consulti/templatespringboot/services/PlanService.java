package com.consulti.templatespringboot.services;


import java.util.*;

import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.PlanModel;


@Service
public interface PlanService {
    List<PlanModel> listar() throws Exception;


    PlanModel save(PlanModel request) throws Exception;

    PlanModel update(PlanModel request) throws Exception;

    Boolean delete(PlanModel request) throws Exception;
    
}
