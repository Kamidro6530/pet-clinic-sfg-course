package com.example.petclinicsfgcourse.services;

import com.example.petclinicsfgcourse.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
