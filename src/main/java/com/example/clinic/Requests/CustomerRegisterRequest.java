package com.example.clinic.Requests;

import com.example.clinic.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerRegisterRequest {
    @JsonProperty("name")
    String name;
    @JsonProperty("surname")
    String surname;
    @JsonProperty("gender")
    Gender gender;
    @JsonProperty("email")
    String email;
    @JsonProperty("password")
    String password;
}
