package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BrandDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService{
    BrandDto create(BrandDto t);

    void destroy(BrandDto t);

    void destroyById(UUID id);

    Optional<BrandDto> find(UUID id);

    List<BrandDto> getAll();
}
