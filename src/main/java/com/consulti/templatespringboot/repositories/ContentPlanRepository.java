package com.consulti.templatespringboot.repositories;

import com.consulti.templatespringboot.models.ContentPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentPlanRepository
  extends JpaRepository<ContentPlanModel, Long> {}
