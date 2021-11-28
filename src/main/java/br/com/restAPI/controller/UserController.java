package br.com.restAPI.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restAPI.Dtos.UserDto;
import br.com.restAPI.models.User;
import br.com.restAPI.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping()
  public List<UserDto> getAllUser() {
    List<User> users = this.userRepository.findAll();

    return users.stream().map(UserDto::new).collect(Collectors.toList());
  }

  @GetMapping("{id}")
  public User getOne(@PathVariable Long id) {
    Optional<User> userFind = this.userRepository.findById(id);
    if (userFind.isPresent()) {
      return userFind.get();
    }

    return null;
  }

  @GetMapping("/greater/{id}")
  public List<User> getGreaterThan(@PathVariable Long id) {
    List<User> usersFind = this.userRepository.findByIdGreaterThan(id);
    return usersFind;
  }

  @PostMapping
  public User create(@RequestBody User user) {
    this.userRepository.save(user);
    return user;
  }

}
