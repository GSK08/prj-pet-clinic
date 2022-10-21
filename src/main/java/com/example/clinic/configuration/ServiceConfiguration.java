package com.example.clinic.configuration;

import com.example.clinic.Daos.AffiliateDao.AffiliateRepository;
import com.example.clinic.Daos.AffiliateDao.AffiliateService;
import com.example.clinic.Daos.AffiliateDao.AffiliateServiceImp;
import com.example.clinic.Daos.UserDao.CustomerRepository;
import com.example.clinic.Daos.UserDao.CustomerService;
import com.example.clinic.Daos.UserDao.CustomerServiceImpl;
import com.example.clinic.Daos.petDao.PetRepository;
import com.example.clinic.Daos.petDao.PetService;
import com.example.clinic.Daos.petDao.PetServiceImp;
import com.example.clinic.EntityManager.EntityManager;
import com.example.clinic.facade.AppFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {


    private final PetRepository petRepository;
    private final AffiliateRepository affiliateRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService userService;

    @Autowired
    ServiceConfiguration(PetRepository repository,
                         AffiliateRepository affiliateRepository, CustomerRepository customerRepository, CustomerService userService){
        this.petRepository =  repository;
        this.affiliateRepository = affiliateRepository;
        this.customerRepository = customerRepository;
        this.userService = userService;
    }

    @Bean
    public AppFacade getFacade(){
        return new AppFacade(getPetService(), getAffiliateService(),
                getCustomerService(), new EntityManager());
    }

    private PetService getPetService(){
        return new PetServiceImp(petRepository);
    }

    private AffiliateService getAffiliateService(){
        return new AffiliateServiceImp(affiliateRepository);
    }

    private CustomerService getCustomerService(){
        return new CustomerServiceImpl(customerRepository);
    }

}
