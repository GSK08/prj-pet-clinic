package com.example.clinic.Daos.petDao;

import com.example.clinic.Dtos.PetDto;
import com.example.clinic.model.Converter;
import com.example.clinic.model.Pet;
import com.example.clinic.model.PetType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PetServiceImp implements PetService{
    private static final Converter<Pet, PetDto> converter =
            pet -> new PetDto(pet.getRegNumber(), pet.getName(),
                    pet.getAge(), pet.getPetType());
    private PetRepository repository;

    @Override
    public Optional<PetDto> getPetByName(String name) {
        Pet petByName = repository.findPetByName(name);
        return Optional.of(converter.convert(petByName));
    }

    @Override
    public List<PetDto> listAllPetsByAdoption() {
        return repository.findPetsBeforeAdopted(Sort.by(Sort.Direction.ASC, "name"))
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> listBySpecie(PetType petType) {
        return repository.findPetsBeforeAdopted(Sort.by(Sort.Direction.ASC, "name")).
                stream().filter(pet -> pet.getPetType().equals(petType))
                .map(converter::convert).
                collect(Collectors.toList());
    }

    @Override
    public PetDto insertPet(Pet pet) {
        Pet save = repository.save(pet);
        return converter.convert(save);
    }
}
