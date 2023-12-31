package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ModelDto;
import com.example.springdatabasicdemo.exeptions.ModelNotFoundExeption;
import com.example.springdatabasicdemo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/models")
public class ModelController {

//    @Autowired
    private ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/models")
    Iterable<ModelDto> all() {
        return modelService.getAll();
    }
    @GetMapping("/models/{id}")
    Optional<ModelDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(modelService.find((id)).orElseThrow(() -> new ModelNotFoundExeption(id)));
    }
    @DeleteMapping("/models/{id}")
    void delete(@PathVariable UUID id) {
        modelService.destroyById(id);
    }
    @PostMapping("/models")
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.create(model);
    }
}
