package com.example.clinic.Requests;

import com.example.clinic.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AffiliateRegisterRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("mail")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("gender")
    private Gender gender;
}
