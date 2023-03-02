package com.example.petclinicsfgcourse.services;

import com.example.petclinicsfgcourse.model.Owner;
import com.example.petclinicsfgcourse.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
