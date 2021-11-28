package br.com.restAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restAPI.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

  public List<User> findByIdGreaterThan(Long id);

}
