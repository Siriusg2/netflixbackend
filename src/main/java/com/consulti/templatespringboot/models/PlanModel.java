package com.consulti.templatespringboot.models;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Data
@Entity
@Table(name = "plans")
@SequenceGenerator(name = "plans_sequence", sequenceName = "plans_sequence", allocationSize = 1)
public class PlanModel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plans_sequence")
  @Column(name = "plan_id", unique = true, updatable = false)
  private Long id;

  private String name;

  @Column(name = "user_id")
  private Long user_id;

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
  @OneToMany(mappedBy = "plan")
  @JsonIgnore
  private List<UsersModel> users;
}
