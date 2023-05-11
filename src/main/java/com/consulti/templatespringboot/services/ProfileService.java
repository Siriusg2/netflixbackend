package com.consulti.templatespringboot.services;


import com.consulti.templatespringboot.models.ProfilesModel;

import java.util.*;

import org.springframework.stereotype.Service;



@Service
public interface ProfileService {

    List<ProfilesModel> listar() throws Exception;


    ProfilesModel save(ProfilesModel request) throws Exception;

    ProfilesModel update(ProfilesModel request) throws Exception;

    Boolean delete(Long request) throws Exception;
    
}
