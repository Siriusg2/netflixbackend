package com.consulti.templatespringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@SequenceGenerator(
  name = "users_sequence",
  sequenceName = "users_sequence",
  allocationSize = 1
)
@Table(name = "users")
public class UsersModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "users_sequence"
  )
  @Column(name = "user_id", unique = true, updatable = false)
  private Long id;

  @Column(unique = true, nullable = false, name = "email")
  private String email;

  @Column(name = "password", nullable = false)
  @JsonIgnore
  private String password;

  @Column(name = "date_born", nullable = false)
  private String dateBorn;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "created_date")
  private Date createdDate;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "modified_date")
  private Date modifiedDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "modified_by")
  private String modifiedBy;

  //RELATIONSHIPS
  @OneToMany(mappedBy = "user")
  private List<ProfilesModel> profiles;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private List<PaymentsModel> payments;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private RolesModel role;

  @ManyToOne
  @JoinColumn(name = "plan_id")
  private PlanModel plan;
}
