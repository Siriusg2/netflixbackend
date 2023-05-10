package com.consulti.templatespringboot.models;
import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name ="plans")
public class PlanModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_id")
    private int id;

    private String name;

    @Column(name="user_id")
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
        createdBy = "nombreUsuario"; // Aquí se debe obtener el nombre del usuario que realiza la acción
    }
    
    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
        modifiedBy = "nombreUsuario"; // Aquí se debe obtener el nombre del usuario que realiza la acción
    }


    //RELATIONSHIPS 
    
    @OneToMany(mappedBy = "plan")
    private List<UsersModel> users;





    //CONSTRUCTORS 
    public PlanModel() {

    }


    
    public PlanModel(int id, String name, LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy,
            String modifiedBy) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
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

}
