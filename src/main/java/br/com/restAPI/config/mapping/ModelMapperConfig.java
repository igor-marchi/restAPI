package br.com.restAPI.config.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.restAPI.domain.models.User;
import br.com.restAPI.dtos.UserDto;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {
    var modelMapper = new ModelMapper();

    modelMapper.createTypeMap(User.class, UserDto.class);

    return modelMapper;
  }

}
