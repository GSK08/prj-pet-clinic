package com.example.clinic.Dtos;

import com.example.clinic.model.PetType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AffiliatePetDto extends PetDto {
    @JsonProperty("is_adopted")
    private boolean isAdopted;

    public AffiliatePetDto(UUID regNumber, String name, int age, PetType petType, boolean adopted) {
        super(regNumber, name, age, petType);
        this.isAdopted = adopted;
    }
}
