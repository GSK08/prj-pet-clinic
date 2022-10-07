package com.example.clinic.Requests;

import com.example.clinic.model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AffiliateRegisterRequest extends AffiliateSignInRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("gender")
    private Gender gender;

    public AffiliateRegisterRequest(String name, String surname, Gender gender ,String email, String password) {
        super(email, password);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
}
