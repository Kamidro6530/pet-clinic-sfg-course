package com.example.petclinicsfgcourse.services.springdatajpa;

import com.example.petclinicsfgcourse.model.Vet;
import com.example.petclinicsfgcourse.repositories.VetRepository;
import com.example.petclinicsfgcourse.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpringDataJpa implements VetService {
    private final VetRepository vetRepository;

    public VetSpringDataJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
       Set<Vet> vets =new HashSet<Vet>();
       vetRepository.findAll().forEach(vets::add);
       return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
