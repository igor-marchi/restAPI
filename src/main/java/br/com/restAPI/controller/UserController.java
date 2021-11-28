package br.com.restAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restAPI.models.User;

@RestController
@RequestMapping("users")
public class UserController {

  private List<User> users = new ArrayList<>();

  @GetMapping()
  public List<User> getAllUser() {
    return users;
  }

  @GetMapping("{id}")
  public User getOne(@PathVariable Long id) {
    Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
    if (userFind.isPresent()) {
      return userFind.get();
    }

    return null;
  }

  @PostMapping
  public User create(@RequestBody User user) {
    users.add(user);
    return user;
  }

}
