package com.example.clinic.Daos.petDao;

import com.example.clinic.Dtos.PetDto;
import com.example.clinic.model.Pet;
import com.example.clinic.model.PetType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PetService {
    Optional<PetDto> getPetByName(String name);
    List<PetDto> listAllPetsByAdoption();
    List<PetDto> listBySpecie(PetType petType);
    PetDto insertPet(Pet pet);
}
