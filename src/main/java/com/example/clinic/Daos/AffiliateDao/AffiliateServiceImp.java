package com.example.clinic.Daos.AffiliateDao;

import com.example.clinic.Dtos.AffiliateDto;
import com.example.clinic.Dtos.AffiliatePetDto;
import com.example.clinic.model.Affiliate;g

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AffiliateServiceImp extends AffiliateService{

    public AffiliateServiceImp(AffiliateRepository affiliateRepository) {
        super(affiliateRepository);
    }

    @Override
    public List<AffiliatePetDto> listPetsAddedByAffiliate(String email) {
        return repository.checkAffiliateByEmail(email).getPets()
                .stream().map(this::ConvertPetToAffiliatePetDto)
                .collect(Collectors.toList());
    }

    @Override
    public AffiliateDto Register(Affiliate affiliate) {
        Affiliate save = repository.save(affiliate);
        return new AffiliateDto(save.getEmail(), save.getGender(),
                save.getName(), save.getName());
    }

    @Override
    public Optional<Affiliate> CheckAffiliateByEmail(String email) {
        return Optional.ofNullable(repository.checkAffiliateByEmail(email));
    }

    @Override
    public boolean SignIn(String email, String password) {
        return repository.affiliateSignIn(email, password) != null;
    }
}
