package com.consulti.templatespringboot.models;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Data
@Entity
@Table(name = "users")
public class UsersModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", unique = true, updatable = false)
  private int id;

  private String email;
  private String password;
  private String date_born;

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
  @OneToMany(mappedBy = "user")
  private List<ProfilesModel> profile;

  @OneToMany(mappedBy = "payment")
  private List<PaymentsModel> payment;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private RolesModel role;

  @ManyToOne
  @JoinColumn(name = "plan_id")
  private PlanModel plan;
}
