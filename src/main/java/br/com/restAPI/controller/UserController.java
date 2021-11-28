package br.com.restAPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restAPI.dtos.UserDto;
import br.com.restAPI.domain.models.User;
import br.com.restAPI.domain.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping()
  public List<UserDto> getAllUser() {
    var users = this.userRepository.findAll();

    var userDto = users
        .stream()
        .map(user -> modelMapper.map(user, UserDto.class))
        .collect(Collectors.toList());

    return userDto;
  }

  @GetMapping("{id}")
  public User getOne(@PathVariable Long id) {
    var userFind = this.userRepository.findById(id);
    if (userFind.isPresent()) {
      return userFind.get();
    }

    return null;
  }

  @GetMapping("/greater/{id}")
  public List<User> getGreaterThan(@PathVariable Long id) {
    var usersFind = this.userRepository.findByIdGreaterThan(id);
    return usersFind;
  }

  @PostMapping
  public User create(@RequestBody User user) {
    this.userRepository.save(user);
    return user;
  }

}
