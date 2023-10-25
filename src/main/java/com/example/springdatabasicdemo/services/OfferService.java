package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.OfferDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    OfferDto create(OfferDto t);

    void destroy(OfferDto t);

    void destroyById(UUID id);

    Optional<OfferDto> find(UUID id);

    List<OfferDto> getAll();
}
