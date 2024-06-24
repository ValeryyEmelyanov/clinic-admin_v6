package com.springlesson.clinicadmin.examples.service;


import com.springlesson.clinicadmin.examples.dto.AnimalRequest;
import com.springlesson.clinicadmin.examples.entity.Animal;
import com.springlesson.clinicadmin.examples.entity.AnimalShelter;
import com.springlesson.clinicadmin.examples.exception.ShelterException;
import com.springlesson.clinicadmin.examples.repository.AnimalRepository;
import com.springlesson.clinicadmin.examples.repository.AnimalShelterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalService(AnimalRepository animalRepository, AnimalShelterRepository animalShelterRepository) {
        this.animalRepository = animalRepository;
        this.animalShelterRepository = animalShelterRepository;
    }

    public int createAnimal(AnimalRequest animalRequest) throws ShelterException {
        AnimalShelter animalShelter = animalShelterRepository.findById(animalRequest.shelterId())
                .orElseThrow(() -> new ShelterException("Приют с ID " + animalRequest.shelterId() + " не найдет"));
        animalRequest.animal().setAnimalShelter(animalShelter);
        return animalRepository.save(animalRequest.animal()).getId();
    }

    public List<Animal> getAnimalsWithOwnersByShelterId(int shelterId) {
        return animalRepository.getByOwnerIdIsNotNullAndAnimalShelterId(shelterId);
    }

    public Page<Animal> getAnimalsByShelterCode(String shelterCode, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return animalRepository.findByAnimalShelterCode(shelterCode, pageable);
    }

    // @Transactional
    public void setOwnerToAnimal(int ownerId, int animalId) throws ShelterException {
        if (animalRepository.setOwnerByAnimalId(ownerId, animalId) == 0) {
            throw new ShelterException("Животному с ID = " + animalId +
                    " не удалось установить владельца с ID " + ownerId);
        }
    }
}


// entity
// repository
// service
// controller

// controller - service:
//  repository (entity),
//  service