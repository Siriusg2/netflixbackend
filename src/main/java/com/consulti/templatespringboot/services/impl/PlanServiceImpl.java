package com.consulti.templatespringboot.services.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.PlanRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.PlanValidations;

@Service
public class PlanServiceImpl implements PlanService {
    
    @Autowired
    PlanRepository  planRepository;
    
    @Autowired
    PlanValidations planValidations;

    @Override
  public List<PlanModel> listar() throws Exception {
      return planRepository.findAll();
  }
  

  @Override
  public PlanModel save(PlanModel request) throws Exception {
    try {
      return planRepository.save(request);
    } catch (Exception e) {
      throw new Exception(
        "Error al guardar el registro del plan: " + e.getMessage()
      );
    }
  }

  @Override
  public PlanModel update(PlanModel request) throws Exception {
    Optional<PlanModel> optional = planRepository.findById(
      request.getId()
    );
    if (optional.isPresent()) {
        PlanModel existingPayment = optional.get();
      existingPayment.setName(request.getName());
      existingPayment.setCreatedDate(request.getCreatedDate());
      existingPayment.setModifiedDate(request.getModifiedDate());
      existingPayment.setCreatedBy(request.getCreatedBy());
      existingPayment.setModifiedBy(request.getModifiedBy());
      existingPayment.setUser_id(request.getUser_id());
      // Guardamos los cambios en la base de datos
      return planRepository.save(existingPayment);
    } else {
      throw new Exception("No se encontró el registro a actualizar");
    }
  }

  @Override
  public Boolean delete(PlanModel request) throws Exception {
    try {
        planRepository.deleteById(request.getId());
      return true;
    } catch (Exception e) {
      throw new Exception(
        "Error deleting payment with id " +
        request.getId() +
        ": " +
        e.getMessage()
      );
    }
  }
}
