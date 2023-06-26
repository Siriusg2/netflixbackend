package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.PaymentRepository;
import com.consulti.templatespringboot.repositories.UserRepository;
import com.consulti.templatespringboot.services.*;
import com.consulti.templatespringboot.utils.validations.PaymentsValidations;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsServiceImpl implements PaymentsService {

  @Autowired
  PaymentRepository paymentRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  PaymentsValidations paymentsValidations;

  @Override
  public List<PaymentsModel> listar() throws Exception {
    return paymentRepository.findAll();
  }

  @Override
  public PaymentsModel save(String idUser) throws Exception {
    try {
      Long id = Long.parseLong(idUser);
      UsersModel user = userRepository.findById(id).get();

      PaymentsModel newPayment = new PaymentsModel();

      newPayment.setCreatedBy(user.getEmail());
      newPayment.setUser(user);
      return paymentRepository.save(newPayment);
    } catch (Exception e) {
      throw new Exception(
        "Error al guardar el registro de pago: " + e.getMessage()
      );
    }
  }

  @Override
  public PaymentsModel update(PaymentsModel request) throws Exception {
    Optional<PaymentsModel> optional = paymentRepository.findById(
      request.getId()
    );
    if (optional.isPresent()) {
      PaymentsModel existingPayment = optional.get();

      existingPayment.setCreatedDate(request.getCreatedDate());
      existingPayment.setModifiedDate(request.getModifiedDate());
      existingPayment.setCreatedBy(request.getCreatedBy());
      existingPayment.setModifiedBy(request.getModifiedBy());
      existingPayment.setUser(request.getUser());
      // Guardamos los cambios en la base de datos
      return paymentRepository.save(existingPayment);
    } else {
      throw new Exception("No se encontró el registro a actualizar");
    }
  }

  @Override
  public Boolean delete(PaymentsModel request) throws Exception {
    try {
      paymentRepository.deleteById(request.getId());
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
