package com.example.clinic.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffiliateSignInRequest {
    @JsonProperty("mail")
    protected String email;
    @JsonProperty("password")
    protected String password;
}
