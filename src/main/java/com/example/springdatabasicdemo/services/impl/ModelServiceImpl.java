package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.repositories.ModelRepository;
import com.example.springdatabasicdemo.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ModelDto create(ModelDto modelDto) {
        Model s = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(s), ModelDto.class);
    }

    @Override
    public void destroy(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Optional<ModelDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }
}
