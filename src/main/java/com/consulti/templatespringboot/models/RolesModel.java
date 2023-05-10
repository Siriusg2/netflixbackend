package com.consulti.templatespringboot.models;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "roles")
public class RolesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "role_id", unique = true, updatable = false)
  private int id;

  @Column(name = "role_name")
  private String name;

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
  @OneToMany(mappedBy = "role")
  private List<UsersModel> user;
}
