package com.consulti.templatespringboot.models;
import java.time.LocalDateTime;

import javax.persistence.*;



@Entity
@Table(name = "payments")
public class PaymentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private int id;

    private String period;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PaymentsModel payment;

//CONSTRUCTORS
    public PaymentsModel() {


}


public PaymentsModel(int id, String period, LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy,
String modifiedBy, PaymentsModel payment) {


    super();
this.id = id;
this.period = period;
this.createdDate = createdDate;
this.modifiedDate = modifiedDate;
this.createdBy = createdBy;
this.modifiedBy = modifiedBy;
this.payment = payment;
}

//getters and setters


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getPeriod() {
    return period;
}

public void setPeriod(String period) {
    this.period = period;
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

public PaymentsModel getPayment() {
    return payment;
}

public void setPayment(PaymentsModel payment) {
    this.payment = payment;
}
    

   

    

    
}
