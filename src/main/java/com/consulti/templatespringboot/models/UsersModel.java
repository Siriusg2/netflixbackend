package com.consulti.templatespringboot.models;
import javax.persistence.*;


@Entity
@Table(name= "users")
public class UsersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String email;
    private String password;
    private String date_born;

    // @ManyToOne
    // @JoinColumn(name="profiles_id")
    // private int ProfilesModel profiles;

    // @ManyToOne
    // @JoinColumn(name="plan_id")
    // private int PlanModel plan; 

    // @ManyToOne
    // @JoinColumn(name="role_id")
    // private int RolesModel role; 

    //CONSTRUCTORS 

    //DEFAULT 
    public UsersModel() {
   
    }
    
    //COMPLETE
    public UsersModel(int id, String email, String password, String date_born) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.date_born = date_born;
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

    

}
