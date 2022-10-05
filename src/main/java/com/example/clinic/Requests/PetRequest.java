package com.example.clinic.Requests;


import com.example.clinic.model.PetType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PetRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("specie")
    private PetType petType;
}
