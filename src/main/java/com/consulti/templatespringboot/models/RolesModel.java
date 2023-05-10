package com.consulti.templatespringboot.models;
import java.time.*;
import java.util.*;
import javax.persistence.*;




@Entity
@Table(name="roles")
public class RolesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;

    @Column(name="role_name")
    private String name;

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
    @OneToMany(mappedBy = "role")
    private List<UsersModel> users;
    

//CONSTRUCTOS 

public RolesModel() {
   
}
public RolesModel(int id, String name, LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy,
        String modifiedBy) {
            super();
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

    
}
