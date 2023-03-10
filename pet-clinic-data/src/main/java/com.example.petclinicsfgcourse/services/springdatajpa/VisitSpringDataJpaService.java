package com.example.petclinicsfgcourse.services.springdatajpa;

import com.example.petclinicsfgcourse.model.Visit;
import com.example.petclinicsfgcourse.repositories.VisitRepository;
import com.example.petclinicsfgcourse.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSpringDataJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> sets = new HashSet<>();
        visitRepository.findAll().forEach(sets::add);
        return sets;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
