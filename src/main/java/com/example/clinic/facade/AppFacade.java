package com.example.clinic.facade;

import com.example.clinic.Daos.AffiliateDao.AffiliateService;
import com.example.clinic.Daos.UserDao.CustomerRepository;
import com.example.clinic.Daos.UserDao.CustomerService;
import com.example.clinic.Daos.petDao.PetService;
import com.example.clinic.Dtos.AffiliateDto;
import com.example.clinic.Dtos.AffiliatePetDto;
import com.example.clinic.Dtos.PetDto;
import com.example.clinic.EntityManager.EntityManager;
import com.example.clinic.Requests.AffiliateRegisterRequest;
import com.example.clinic.Requests.AffiliateSignInRequest;
import com.example.clinic.Requests.PetRequest;
import com.example.clinic.exceptions.PetNotFoundException;
import com.example.clinic.model.Affiliate;
import com.example.clinic.model.Pet;
import com.example.clinic.model.PetType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class AppFacade {

    private final PetService petService;
    private final AffiliateService affiliateService;
    private final CustomerService customerService;
    private final EntityManager manager;

    public ResponseEntity<List<PetDto>> listAllPets(){
      log.info("Trying to retrieve pet list from storage");
      List<PetDto> petDtos = petService.listAllPetsByAdoption();
      if(petDtos.isEmpty()){
          log.warn("Pets are not added yet");
          throw new PetNotFoundException("Pet list is empty");
      }
      return manager.EntityOnList(petDtos);
    }

    public ResponseEntity<List<PetDto>> listPetsBySpecie(PetType petType){
        log.info("Trying to retrieve pet-list of {} from storage", petType.toString());
        List<PetDto> petDtos = petService.listBySpecie(petType);
        if(petDtos.isEmpty()){
            log.warn("Specie {} not found", petType);
            throw new PetNotFoundException("Pet list is empty");
        }
        return manager.EntityOnList(petDtos);
    }

    public ResponseEntity<PetDto> addPet(PetRequest request, String affiliateMail){
        log.info("Trying to add a Pet {} into the storage", request);
        Pet convertedPet = ConverterFactory.PET_REQUEST_PET_CONVERTER.convert(request);
        Affiliate affiliate = affiliateService.CheckAffiliateByEmail(affiliateMail)
                .orElseThrow(() -> new IllegalArgumentException("Affiliate with this email doesn't exist!"));
        log.info("Inserting pet {} for affiliate {}", convertedPet, affiliate);
        convertedPet.setAffiliate(affiliate);
        PetDto petDto = petService.insertPet(convertedPet);
        if(petDto == null){
            log.warn("Error saving Pet!");
            throw new RuntimeException("Couldn't save Pet");
        }
        return manager.EntityOnCreated(petDto);
    }

    public ResponseEntity<AffiliateDto> signUp(AffiliateRegisterRequest request){
        log.info("Trying to register affiliate {}",request);
        Optional<Affiliate> affiliate = affiliateService.CheckAffiliateByEmail(request.getEmail());
        if (affiliate.isPresent()){
            log.warn("Email {} already registered", request.getEmail());
            throw new IllegalArgumentException("Email is already registered");
        }
        Affiliate ConvertedAffiliate = ConverterFactory.AFFILIATE_REGISTER_REQUEST_AFFILIATE_CONVERTER.convert(request);
        AffiliateDto register = affiliateService.Register(ConvertedAffiliate);
        log.info("Registered affiliate {}", register);
        return manager.EntityOnCreated(register);
    }

    public boolean singIn(AffiliateSignInRequest request){
        log.info("Trying to register affiliate {}",request);
        Affiliate affiliate = affiliateService.CheckAffiliateByEmail(request.getEmail())
                .orElseThrow(() ->new RuntimeException("Affiliate with this email is not registered"));
        return affiliateService.SignIn(affiliate.getEmail(), affiliate.getPassword());
    }

    public List<AffiliatePetDto> listAffiliatePets(String AffiliateMail){
        Affiliate affiliate = affiliateService.CheckAffiliateByEmail(AffiliateMail)
                .orElseThrow(() -> new IllegalArgumentException("Affiliate with this mail doesn't exist!"));
        List<AffiliatePetDto> petsAddedByAffiliate = affiliateService.listPetsAddedByAffiliate(AffiliateMail);
        log.info("Retrieving pets for affiliate {}", affiliate);
        return petsAddedByAffiliate;
    }

}
