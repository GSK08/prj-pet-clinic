package com.example.clinic.Daos.UserDao;

import com.example.clinic.Dtos.CustomerDto;
import com.example.clinic.Dtos.PetDto;
import com.example.clinic.Requests.CustomerRegisterRequest;
import com.example.clinic.model.Converter;
import com.example.clinic.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Converter<Customer, CustomerDto> CUSTOMER_CUSTOMER_DTO_CONVERTER
            = customer -> new CustomerDto(customer.getName(), customer.getSurname(),
            customer.getEmail(), customer.getGender());
    Optional<CustomerDto> register(CustomerRegisterRequest request);
    boolean signIn(String email, String password);
    void adoptPet(PetDto petDto, String email);

}
