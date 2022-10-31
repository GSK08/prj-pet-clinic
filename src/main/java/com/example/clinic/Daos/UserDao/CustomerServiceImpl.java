package com.example.clinic.Daos.UserDao;

import com.example.clinic.Dtos.CustomerDto;
import com.example.clinic.Dtos.PetDto;
import com.example.clinic.Requests.CustomerRegisterRequest;
import com.example.clinic.facade.ConverterFactory;
import com.example.clinic.model.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerDto> register(CustomerRegisterRequest request) {
        Customer convertedCustomer = ConverterFactory.
                CUSTOMER_REGISTER_REQUEST_CUSTOMER_CONVERTER.convert(request);
        log.info("Trying to check email for customer {}", convertedCustomer);
        Customer customerByEmail = customerRepository.findCustomerByEmail(request.getEmail());
        if (customerByEmail != null){
            log.info("Customer with email {} is already registered", convertedCustomer.getEmail());
            throw new IllegalArgumentException("Email already registered!");
        }
        Customer save = customerRepository.save(convertedCustomer);
        log.info("Customer {} was successfully registered", save);
        return Optional.ofNullable(CUSTOMER_CUSTOMER_DTO_CONVERTER.convert(save));
    }

    @Override
    public boolean signIn(String email, String password) {
        return false;
    }

    @Override
    public void adoptPet(PetDto petDto, String email) {

    }
}
