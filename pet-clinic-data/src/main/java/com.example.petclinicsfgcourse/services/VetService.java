package com.example.petclinicsfgcourse.services;

import com.example.petclinicsfgcourse.model.Pet;
import com.example.petclinicsfgcourse.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
