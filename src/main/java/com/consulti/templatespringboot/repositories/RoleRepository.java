package com.consulti.templatespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulti.templatespringboot.models.RolesModel;

public interface RoleRepository  extends JpaRepository<RolesModel, Long>{
    
}
