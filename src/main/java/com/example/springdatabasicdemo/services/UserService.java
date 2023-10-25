package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    
    UserDto create(UserDto t);

    void destroy(UserDto t);

    void destroyById(UUID id);

    Optional<UserDto> find(UUID id);

    List<UserDto> getAll();
}
