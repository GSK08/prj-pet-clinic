package com.example.clinic.Daos.petDao;

import com.example.clinic.model.Pet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p from Pet p where p.name = :name")
    Pet findPetByName(@Param("name") String name);

    @Query("SELECT p from Pet p where p.isAdopted = false")
    List<Pet> findPetsBeforeAdopted(Sort name);

}
