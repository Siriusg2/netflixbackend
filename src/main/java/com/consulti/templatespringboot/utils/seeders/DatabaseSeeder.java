package com.consulti.templatespringboot.utils.seeders;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements ApplicationRunner {

  @Autowired
  private RoleRepository rolesRepository;

  @Autowired
  private PlanRepository planRepository;
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    
    createRoles();
    createPlans();
    System.out.println("Seeders finished" );
    createUsers();
  }

  private void createRoles() {
    RolesModel role1 = new RolesModel();
    role1.setName("Admin");
    role1.setCreatedBy("AdminDB");

    role1.setCreatedDate(new Date());

    rolesRepository.save(role1);

    RolesModel role2 = new RolesModel();
    role2.setName("User");
    role2.setCreatedBy("AdminDB");

    role2.setCreatedDate(new Date());

    rolesRepository.save(role2);
  }

  private void createPlans() {
    PlanModel plan1 = new PlanModel();
    plan1.setName("Basico");
    plan1.setUser_id(1L);
    plan1.setCreatedBy("AdminDB");

    plan1.setCreatedDate(new Date());

    planRepository.save(plan1);

    PlanModel plan2 = new PlanModel();
    plan2.setName("Intermedio");
    plan2.setUser_id(1L);
    plan2.setCreatedBy("AdminDB");

    plan2.setCreatedDate(new Date());

    planRepository.save(plan2);

    PlanModel plan3 = new PlanModel();
    plan3.setName("Avanzado");
    plan3.setUser_id(1L);
    plan3.setCreatedBy("AdminDB");

    plan3.setCreatedDate(new Date());

    planRepository.save(plan3);
  }

  private void createUsers() {
    RolesModel rolAdmin = rolesRepository.findById(1L).get();
    RolesModel rolUser = rolesRepository.findById(2L).get();

    PlanModel planBasic = planRepository.findById(3L).get();
    PlanModel planIntermediate = planRepository.findById(4L).get();
    PlanModel planAdvanced = planRepository.findById(5L).get();

    UsersModel user1 = new UsersModel();
    user1.setEmail("user1@example.com");
    user1.setPassword("password1");
    user1.setDate_born("1990-01-01");
    user1.setCreatedBy("AdminDB");
    user1.setRole(rolAdmin);
    user1.setPlan(planAdvanced);
    userRepository.save(user1);



    UsersModel user2 = new UsersModel();
    user2.setEmail("user2@example.com");
    user2.setPassword("password2");
    user2.setDate_born("1990-01-01");
    user2.setCreatedBy("AdminDB");
    user2.setRole(rolUser);
    user2.setPlan(planBasic);
    userRepository.save(user2);


    UsersModel user3 = new UsersModel();
    user3.setEmail("user3@example.com");
    user3.setPassword("password3");
    user3.setDate_born("1990-01-01");
    user3.setCreatedBy("AdminDB");
    user3.setRole(rolUser);
    user3.setPlan(planIntermediate);
    userRepository.save(user3);


    UsersModel user4 = new UsersModel();
    user4.setEmail("user4@example.com");
    user4.setPassword("password4");
    user4.setDate_born("1990-01-01");
    user4.setCreatedBy("AdminDB");
    user4.setRole(rolAdmin);
    user4.setPlan(planAdvanced);
    userRepository.save(user4);

    
  }
}
