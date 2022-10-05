package com.example.clinic.Dtos;

import com.example.clinic.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AffiliateDto {
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;

}
