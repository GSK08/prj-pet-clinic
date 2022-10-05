package com.example.clinic.Dtos;


import com.example.clinic.model.PetType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    @JsonProperty("registration_number")
    protected UUID regNumber;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("age")
    protected int age;
    @JsonProperty("type")
    protected PetType petType;
}
