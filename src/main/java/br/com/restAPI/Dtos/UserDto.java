package br.com.restAPI.dtos;

import br.com.restAPI.models.User;
import lombok.Data;

@Data
public class UserDto {

  public UserDto(User user) {
    this.name = user.getName();
    this.userName = user.getUserName();
  }

  private String name;
  private String userName;
}
