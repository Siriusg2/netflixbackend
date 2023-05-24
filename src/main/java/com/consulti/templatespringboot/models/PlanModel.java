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
@Table(name = "plans")
@SequenceGenerator(
  name = "plans_sequence",
  sequenceName = "plans_sequence",
  allocationSize = 1
)
public class PlanModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "plans_sequence"
  )
  @Column(name = "plan_id", unique = true, updatable = false)
  private Long id;

  @Column(unique = true)
  private String name;

  @Column(name = "minor_content")
  private String minorContent;

  @Column(name = "adult_content")
  private String adultContent;

  @Column(name = "advanced_content")
  private String advancedContent;

  @Column(name = "user_id")
  private Long user_id;

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
  @OneToMany(mappedBy = "plan")
  @JsonIgnore
  private List<UsersModel> users;

  @ManyToMany
  @JoinTable(
    name = "plan_content",
    joinColumns = @JoinColumn(name = "plan_id"),
    inverseJoinColumns = @JoinColumn(name = "content_id")
  )
  private List<ContentPlanModel> content;
}
