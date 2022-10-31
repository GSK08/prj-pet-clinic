package com.example.clinic.facade;

import com.example.clinic.Requests.AffiliateRegisterRequest;
import com.example.clinic.Requests.CustomerRegisterRequest;
import com.example.clinic.Requests.PetRequest;
import com.example.clinic.model.Affiliate;
import com.example.clinic.model.Converter;
import com.example.clinic.model.Customer;
import com.example.clinic.model.Pet;

public class ConverterFactory {
    public static final Converter<PetRequest, Pet> PET_REQUEST_PET_CONVERTER = request ->
            new Pet(request.getName(),
                    request.getAge(), request.getPetType());

    public static final Converter<AffiliateRegisterRequest, Affiliate> AFFILIATE_REGISTER_REQUEST_AFFILIATE_CONVERTER
            = request -> new Affiliate(request.getEmail(), request.getPassword(),
            request.getGender(), request.getName(), request.getSurname());

    public static final Converter<CustomerRegisterRequest, Customer> CUSTOMER_REGISTER_REQUEST_CUSTOMER_CONVERTER
            = request -> new Customer(request.getName(), request.getSurname(),
            request.getEmail(), request.getPassword(), request.getGender());
}
