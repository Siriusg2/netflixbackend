package com.consulti.templatespringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "profiles")
public class ProfilesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "profile_id", unique = true, updatable = false)
  private Long id;

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

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UsersModel user;
}
