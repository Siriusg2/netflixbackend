package com.consulti.templatespringboot.models;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "plans")
public class PlanModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "plan_id", unique = true, updatable = false)
  private Long id;

  private String name;

  @Column(name = "user_id")
  private Long user_id;

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

  @OneToMany(mappedBy = "plan")
  private List<UsersModel> users;
}
