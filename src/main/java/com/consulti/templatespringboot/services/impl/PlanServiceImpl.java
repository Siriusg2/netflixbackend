package com.consulti.templatespringboot.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.repositories.PlanRepository;
import com.consulti.templatespringboot.services.*;

@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    PlanRepository  planRepository;
    
}
