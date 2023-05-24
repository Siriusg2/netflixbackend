package com.consulti.templatespringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "content")
@SequenceGenerator(
  name = "content_sequence",
  sequenceName = "content_sequence",
  allocationSize = 1
)
public class ContentPlanModel {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "content_sequence"
  )
  @Column(name = "content_id", unique = true, updatable = false)
  private Long id;

  private String name;
  private String externalEndpoint;

  @ManyToMany(mappedBy = "content")
  @JsonIgnore
  private List<PlanModel> plans;
}
