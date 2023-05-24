package com.consulti.templatespringboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


import com.consulti.templatespringboot.models.UsersModel;


public interface UserRepository  extends JpaRepository<UsersModel, Long>{

    UsersModel findByEmail(String email);
}
