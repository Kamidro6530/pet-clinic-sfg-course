package com.example.petclinicsfgcourse.repositories;

import com.example.petclinicsfgcourse.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
