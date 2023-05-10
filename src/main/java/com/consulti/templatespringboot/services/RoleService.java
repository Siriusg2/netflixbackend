package com.consulti.templatespringboot.services;

import com.consulti.templatespringboot.models.RolesModel;
import com.consulti.templatespringboot.repositories.RoleRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;



public class RoleService implements RoleRepository {

  @Autowired
  public RoleRepository roleRepository;

  @Override
  public List<RolesModel> findAll() {
return roleRepository.findAll();
  }

  @Override
  public List<RolesModel> findAll(Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public List<RolesModel> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'findAllById'"
    );
  }

  @Override
  public <S extends RolesModel> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'flush'");
  }

  @Override
  public <S extends RolesModel> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'saveAndFlush'"
    );
  }

  @Override
  public <S extends RolesModel> List<S> saveAllAndFlush(Iterable<S> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'saveAllAndFlush'"
    );
  }

  @Override
  public void deleteAllInBatch(Iterable<RolesModel> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteAllInBatch'"
    );
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteAllByIdInBatch'"
    );
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteAllInBatch'"
    );
  }

  @Override
  public RolesModel getOne(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOne'");
  }

  @Override
  public RolesModel getById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public <S extends RolesModel> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends RolesModel> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public Page<RolesModel> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends RolesModel> S save(S entity) {
  return roleRepository.save(entity);
  }

  @Override
  public Optional<RolesModel> findById(Long id) {
   return roleRepository.findById(id);
  }



  @Override
  public long count() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public void deleteById(Long id) {
  roleRepository.deleteById(id);
    
  }

  @Override
  public void delete(RolesModel entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void deleteAllById(Iterable<? extends Long> ids) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteAllById'"
    );
  }

  @Override
  public void deleteAll(Iterable<? extends RolesModel> entities) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

  @Override
  public <S extends RolesModel> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
  }

  @Override
  public <S extends RolesModel> Page<S> findAll(
    Example<S> example,
    Pageable pageable
  ) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public <S extends RolesModel> long count(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'count'");
  }

  @Override
  public <S extends RolesModel> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
  }

  @Override
  public <S extends RolesModel, R> R findBy(
    Example<S> example,
    Function<FetchableFluentQuery<S>, R> queryFunction
  ) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findBy'");
  }

  @Override
  public RolesModel getReferenceById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getReferenceById'"
    );
  }

@Override
public boolean existsById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'existsById'");
}
}