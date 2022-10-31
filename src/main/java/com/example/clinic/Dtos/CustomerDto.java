package com.example.clinic.Dtos;

import com.example.clinic.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class CustomerDto {
    @JsonProperty("transact_id")
    private UUID transactId = UUID.randomUUID();
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private Gender gender;

    public CustomerDto(String name, String surname, String email, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
    }
}
