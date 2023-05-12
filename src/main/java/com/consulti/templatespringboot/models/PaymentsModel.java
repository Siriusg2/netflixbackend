package com.consulti.templatespringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "payments")
@SequenceGenerator(name = "payments_sequence", sequenceName = "payments_sequence", allocationSize = 1)
public class PaymentsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_sequence")
  @Column(name = "payment_id", unique = true, updatable = false)
  private Long id;

  private String period;
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "created_date")
  private java.util.Date createdDate;


  @UpdateTimestamp
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
  private UsersModel payment;


}
