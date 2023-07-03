package com.consulti.templatespringboot.utils.seeders;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

  @Autowired
  private ContentPlanRepository contentPlanRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    createContent();
    createPlans();
    createRoles();
    createUsers();
    System.out.println("Seeders finished");
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
    Optional<ContentPlanModel> kidsContent = contentPlanRepository.findById(1L);
    Optional<ContentPlanModel> adultContent = contentPlanRepository.findById(
      2L
    );
    Optional<ContentPlanModel> exclusiveContent = contentPlanRepository.findById(
      3L
    );

    List<ContentPlanModel> basicAndIntermediateContent = new ArrayList<>();

    basicAndIntermediateContent.add(kidsContent.get());
    basicAndIntermediateContent.add(adultContent.get());

    List<ContentPlanModel> allContent = new ArrayList<>();

    allContent.add(kidsContent.get());
    allContent.add(adultContent.get());
    allContent.add(exclusiveContent.get());

    PlanModel plan1 = new PlanModel();

    plan1.setName("Basico");
    plan1.setUser_id(1L);
    plan1.setCreatedBy("AdminDB");
    plan1.setContent(basicAndIntermediateContent);
    plan1.setCreatedDate(new Date());

    planRepository.save(plan1);

    PlanModel plan2 = new PlanModel();
    plan2.setName("Intermedio");
    plan2.setUser_id(1L);
    plan2.setCreatedBy("AdminDB");

    plan2.setCreatedDate(new Date());
    plan2.setContent(basicAndIntermediateContent);

    planRepository.save(plan2);

    PlanModel plan3 = new PlanModel();
    plan3.setName("Avanzado");
    plan3.setUser_id(1L);
    plan3.setCreatedBy("AdminDB");
    plan3.setContent(allContent);
    plan3.setCreatedDate(new Date());

    planRepository.save(plan3);
  }

  private void createUsers() {
    RolesModel rolAdmin = rolesRepository.findById(1L).get();
    RolesModel rolUser = rolesRepository.findById(2L).get();

    PlanModel planBasic = planRepository.findById(1L).get();
    PlanModel planIntermediate = planRepository.findById(2L).get();
    PlanModel planAdvanced = planRepository.findById(3L).get();

    UsersModel user1 = new UsersModel();
    user1.setEmail("user1@example.com");
    user1.setPassword("password1");
    user1.setDateBorn("1990-01-01");
    user1.setCreatedBy("AdminDB");
    user1.setRole(rolAdmin);
    user1.setPlan(planAdvanced);
    userRepository.save(user1);

    UsersModel user2 = new UsersModel();
    user2.setEmail("user2@example.com");
    user2.setPassword("password2");
    user2.setDateBorn("1990-01-01");
    user2.setCreatedBy("AdminDB");
    user2.setRole(rolUser);
    user2.setPlan(planBasic);
    userRepository.save(user2);

    UsersModel user3 = new UsersModel();
    user3.setEmail("user3@example.com");
    user3.setPassword("password3");
    user3.setDateBorn("1990-01-01");
    user3.setCreatedBy("AdminDB");
    user3.setRole(rolUser);
    user3.setPlan(planIntermediate);
    userRepository.save(user3);

    UsersModel user4 = new UsersModel();
    user4.setEmail("user4@example.com");
    user4.setPassword("password4");
    user4.setDateBorn("1990-01-01");
    user4.setCreatedBy("AdminDB");
    user4.setRole(rolAdmin);
    user4.setPlan(planAdvanced);
    userRepository.save(user4);
  }

  public void createContent() throws Exception {
    ContentPlanModel content1 = new ContentPlanModel();

    content1.setName("Contenido para niños");
    content1.setExternalEndpoint(
      "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=true&language=en-US&page=1&sort_by=popularity.desc"
    );

    contentPlanRepository.save(content1);

    ContentPlanModel content2 = new ContentPlanModel();

    content2.setName("Contenido para Adultos");
    content2.setExternalEndpoint(
      "https://api.themoviedb.org/3/discover/movie?include_adult=true&include_video=true&language=en-US&page=2&sort_by=popularity.desc"
    );

    contentPlanRepository.save(content2);

    ContentPlanModel content3 = new ContentPlanModel();

    content3.setName("Contenido Exclusivo");
    content3.setExternalEndpoint(
      "https://api.themoviedb.org/3/discover/tv?include_adult=false&include_null_first_air_dates=false&language=en-US&page=1&sort_by=popularity.desc"
    );

    contentPlanRepository.save(content3);
  }
}
