package com.example.clinic.controller;

import com.example.clinic.Dtos.PetDto;
import com.example.clinic.Requests.PetRequest;
import com.example.clinic.facade.AppFacade;
import com.example.clinic.model.PetType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pet")
public class PetController {

    private final AppFacade petFacade;

    public PetController(AppFacade petFacade) {
        this.petFacade = petFacade;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PetDto>> listPets(){
        return petFacade.listAllPets();
    }

    @GetMapping("/list/{}")
    public ResponseEntity<List<PetDto>> listPets(@RequestParam PetType petType){
        return petFacade.listPetsBySpecie(petType);
    }

    @PostMapping
    public ResponseEntity<PetDto> insertPet(@RequestBody PetRequest request, @RequestParam String affiliateMail){
        return petFacade.addPet(request, affiliateMail);
    }

}
