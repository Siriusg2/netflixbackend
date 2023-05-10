package com.consulti.templatespringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "payments")
public class PaymentsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "payment_id", unique = true, updatable = false)
  private int id;

  private String period;

  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "created_date")
  private java.util.Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "modified_date")
  private java.util.Date modifiedDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "modified_by")
  private String modifiedBy;

  //RELATIONSHIPS

  @ManyToOne
  @JoinColumn(name = "user_id")
  private PaymentsModel payment;
}
