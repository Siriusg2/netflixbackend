package com.consulti.templatespringboot.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulti.templatespringboot.repositories.ProfileRepository;
import com.consulti.templatespringboot.services.*;

@Service
public class ProfileServiceImpl implements ProfileService {
    
    @Autowired 
    ProfileRepository   profileRepository;
}
