package com.example.clinic.configuration;

import com.example.clinic.Daos.AffiliateDao.AffiliateRepository;
import com.example.clinic.Daos.AffiliateDao.AffiliateService;
import com.example.clinic.Daos.AffiliateDao.AffiliateServiceImp;
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

    @Autowired
    ServiceConfiguration(PetRepository repository,
                         AffiliateRepository affiliateRepository){
        this.petRepository =  repository;
        this.affiliateRepository = affiliateRepository;
    }

    @Bean
    public AppFacade getFacade(){
        return new AppFacade(getPetService(), getAffiliateService(), new EntityManager());
    }

    private PetService getPetService(){
        return new PetServiceImp(petRepository);
    }

    private AffiliateService getAffiliateService(){
        return new AffiliateServiceImp(affiliateRepository);
    }

}
