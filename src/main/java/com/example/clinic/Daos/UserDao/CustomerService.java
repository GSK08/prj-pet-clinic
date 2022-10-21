package com.example.clinic.Daos.UserDao;

import com.example.clinic.Dtos.CustomerDto;
import com.example.clinic.Dtos.PetDto;
import com.example.clinic.Requests.CustomerRegisterRequest;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerDto> register(CustomerRegisterRequest request);
    boolean signIn(String email, String password);
    void adoptPet(PetDto petDto, String email);

}
