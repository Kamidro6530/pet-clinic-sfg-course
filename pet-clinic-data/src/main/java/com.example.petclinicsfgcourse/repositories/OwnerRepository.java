package com.example.petclinicsfgcourse.repositories;

import com.example.petclinicsfgcourse.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
}
