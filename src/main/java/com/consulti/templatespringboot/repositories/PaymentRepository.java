package com.consulti.templatespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulti.templatespringboot.models.PaymentsModel;

public interface PaymentRepository extends JpaRepository<PaymentsModel, Long>{
    
}
