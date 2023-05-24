package com.consulti.templatespringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.consulti.templatespringboot.models.PaymentsModel;
import com.consulti.templatespringboot.services.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    
    @Autowired
    PaymentsService paymentsService;

    @GetMapping("/all")
    public List<PaymentsModel> getAllPayments() throws Exception {
      return paymentsService.listar();
    }
  
    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity <Boolean> deleteUser(@PathVariable Long paymentId) throws Exception {
      
      return ResponseEntity.status(HttpStatus.OK).body(true);
    }
  
    @PostMapping("/save_payment")
    public ResponseEntity<PaymentsModel> savePayment(@RequestBody PaymentsModel newPayment) throws Exception {
  
        PaymentsModel savedPayment = paymentsService.save(newPayment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
     
    }
  
    @PutMapping("/update-payments")
    public ResponseEntity<PaymentsModel> updatePayment(
  
      @RequestBody PaymentsModel paymentDetails
    ) throws Exception {
        PaymentsModel updatedPayment = paymentsService.update( paymentDetails);
      return ResponseEntity.ok(updatedPayment);
    }
}
