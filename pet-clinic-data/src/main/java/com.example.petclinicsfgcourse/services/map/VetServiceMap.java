package com.example.petclinicsfgcourse.services.map;

import com.example.petclinicsfgcourse.model.Speciality;
import com.example.petclinicsfgcourse.model.Vet;
import com.example.petclinicsfgcourse.services.SpecialityService;
import com.example.petclinicsfgcourse.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object!=null){
            if (object.getSpecialities() != null){
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null){
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

