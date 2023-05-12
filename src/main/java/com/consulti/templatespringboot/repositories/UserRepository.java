package com.consulti.templatespringboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consulti.templatespringboot.models.UsersModel;


public interface UserRepository  extends JpaRepository<UsersModel, Long>{
    @Query("SELECT u FROM UsersModel u WHERE u.email = ?1")
    UsersModel findByEmail(String email);
}
