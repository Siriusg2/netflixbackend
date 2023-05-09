package com.consulti.templatespringboot.models;
import javax.persistence.*;


@Entity
@Table(name= "profiles")
public class ProfilesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    
    // @ManyToMany
    // @JoinColumn(name= "profiles_id")
    // private int UsersModel user;

}
