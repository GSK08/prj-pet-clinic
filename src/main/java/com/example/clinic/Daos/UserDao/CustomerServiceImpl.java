package com.example.clinic.Daos.UserDao;

import com.example.clinic.Dtos.CustomerDto;
import com.example.clinic.Dtos.PetDto;
import com.example.clinic.Requests.CustomerRegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerDto> register(CustomerRegisterRequest request) {
        return Optional.empty();
    }

    @Override
    public boolean signIn(String email, String password) {
        return false;
    }

    @Override
    public void adoptPet(PetDto petDto, String email) {

    }
}
