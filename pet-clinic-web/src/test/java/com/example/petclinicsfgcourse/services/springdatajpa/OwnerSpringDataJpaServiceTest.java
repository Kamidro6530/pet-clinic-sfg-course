package com.example.petclinicsfgcourse.services.springdatajpa;

import com.example.petclinicsfgcourse.model.Owner;
import com.example.petclinicsfgcourse.repositories.OwnerRepository;
import com.example.petclinicsfgcourse.repositories.PetRepository;
import com.example.petclinicsfgcourse.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final Long ID = 1L;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSpringDataJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(new Owner());
        ownerSet.add(new Owner());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = service.findAll();

        assertEquals(2,owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(returnOwner));

        Owner owner = service.findById(ID);

        assertNotNull(owner);
        assertEquals(ID,owner.getId());
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner owner = service.findById(ID);

        assertNull(owner);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = service.save(new Owner());

        assertNotNull(owner);
        assertEquals(ID,owner.getId());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(ID);
        verify(ownerRepository,times(1)).deleteById(any());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME,smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}