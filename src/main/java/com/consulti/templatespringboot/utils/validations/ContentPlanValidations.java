package com.consulti.templatespringboot.utils.validations;

import com.consulti.templatespringboot.models.PaymentsModel;
import com.consulti.templatespringboot.models.UsersModel;
import com.consulti.templatespringboot.repositories.ContentPlanRepository;
import com.consulti.templatespringboot.repositories.PaymentRepository;
import com.consulti.templatespringboot.repositories.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentPlanValidations {

  @Autowired
  ContentPlanRepository contentPlanRepository;
}
