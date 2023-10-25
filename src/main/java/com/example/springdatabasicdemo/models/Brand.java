package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(name = "name", length = 255)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    private Set<Model> models = new HashSet<>();

    public Brand() {
    }

    void addModel(Model model){models.add(model);}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
