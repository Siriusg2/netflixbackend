package com.consulti.templatespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulti.templatespringboot.models.PlanModel;

public interface PlanRepository extends JpaRepository<PlanModel, Long> {
    
}
