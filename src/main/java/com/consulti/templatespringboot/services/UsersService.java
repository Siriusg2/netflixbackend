package com.consulti.templatespringboot.services;

import com.consulti.templatespringboot.models.UsersModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
  List<UsersModel> listar() throws Exception;

  UsersModel findByEmail(String email) throws Exception;

  UsersModel login(String email, String password) throws Exception;

  UsersModel save(
    String newUserEmail,
    String newUserPassword,
    String newUserDateBorn,
    String newUserPlan,
    String newUserRole
  ) throws Exception;

  UsersModel update(
    Long userId,
    String newPassword,
    String newDateBorn,
    String newPlan,
    String newRole
  ) throws Exception;

  Boolean delete(Long request) throws Exception;
}
