package com.consulti.templatespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulti.templatespringboot.models.ProfilesModel;

public interface ProfileRepository extends JpaRepository<ProfilesModel, Long> {
    
}
