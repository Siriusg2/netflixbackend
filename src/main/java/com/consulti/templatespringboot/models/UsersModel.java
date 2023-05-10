package com.consulti.templatespringboot.models;

import java.time.LocalDateTime;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name= "users")
public class UsersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;


    private String email;
    private String password;
    private String date_born;
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
    @OneToMany(mappedBy = "user")
    private List<ProfilesModel> profiles;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesModel role;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanModel plan;
    
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentsModel payment;
    
    
    //CONSTRUCTORS
    
        public UsersModel() {
         
        }
        public UsersModel(int id, String email, String password, String date_born, LocalDateTime createdDate,
                LocalDateTime modifiedDate, String createdBy, String modifiedBy) {
                    super();
            this.id = id;
            this.email = email;
            this.password = password;
            this.date_born = date_born;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_born() {
        return date_born;
    }

    public void setDate_born(String date_born) {
        this.date_born = date_born;
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
