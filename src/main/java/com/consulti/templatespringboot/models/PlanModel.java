package com.consulti.templatespringboot.models;

import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "plans")
public class PlanModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "plan_id")
  private int id;

  private String name;

  @Column(name = "user_id")
  private int user_id;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @Column(name = "modified_date")
  private LocalDateTime modifiedDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "modified_by")
  private String modifiedBy;

  @PrePersist
  protected void onCreate() {
    createdDate = LocalDateTime.now();
    
  }

  @PreUpdate
  protected void onUpdate() {
    modifiedDate = LocalDateTime.now();
    
  }

  //RELATIONSHIPS

  @OneToMany(mappedBy = "plan")
  private List<UsersModel> users;

  //CONSTRUCTORS
  public PlanModel() {}

  
  public PlanModel(int id, String name, int user_id, LocalDateTime createdDate, LocalDateTime modifiedDate,
        String createdBy, String modifiedBy, List<UsersModel> users) {
    this.id = id;
    this.name = name;
    this.user_id = user_id;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
    this.createdBy = createdBy;
    this.modifiedBy = modifiedBy;
    this.users = users;
}

  //GETTERS AND SETTERS


public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(LocalDateTime modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public List<UsersModel> getUsers() {
    return users;
  }

  public void setUsers(List<UsersModel> users) {
    this.users = users;
  }
}
