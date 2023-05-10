package com.consulti.seeders;

import com.consulti.templatespringboot.models.*;
import com.consulti.templatespringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  @Autowired
  private PlanRepository planRepository;

  private RoleRepository roleRepository;

  @Override
  public void run(String... args) throws Exception {
    // crea objetos de entidad y guárdalos en la base de datos
    PlanModel plan1 = new PlanModel(1, "Basico", 1, null, null, "adminDB", null, null);
    PlanModel plan2 = new PlanModel(2, "Intermedio", 2, null, null, "adminDB", null, null);
    PlanModel plan3 = new PlanModel(3, "Avanzado", 3, null, null, "adminDB", null, null);
  
    planRepository.save(plan1);
    planRepository.save(plan2);
    planRepository.save(plan3);
    RolesModel role1 = new RolesModel(1, "Administrador", null, null, "adminDB", null, null);
    RolesModel role2 = new RolesModel(2, "Regular", null, null, "adminDB", null, null);

    roleRepository.save(role1);
    roleRepository.save(role2);
  }
}
