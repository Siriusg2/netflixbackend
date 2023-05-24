package com.consulti.templatespringboot.repositories;

import com.consulti.templatespringboot.models.PaymentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentsModel, Long> {}
