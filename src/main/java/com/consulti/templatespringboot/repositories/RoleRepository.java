package com.consulti.templatespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consulti.templatespringboot.models.RolesModel;


public interface RoleRepository  extends JpaRepository<RolesModel, Long>{
    
    @Query("SELECT u FROM RolesModel u WHERE u.name = ?1")
    RolesModel findByName(String name);
}
