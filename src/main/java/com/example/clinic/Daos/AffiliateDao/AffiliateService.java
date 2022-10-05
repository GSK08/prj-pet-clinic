package com.example.clinic.Daos.AffiliateDao;

import com.example.clinic.Dtos.AffiliateDto;
import com.example.clinic.Dtos.AffiliatePetDto;
import com.example.clinic.model.Affiliate;
import com.example.clinic.model.Converter;
import com.example.clinic.model.Pet;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public abstract class AffiliateService {
    private final Converter<Pet, AffiliatePetDto> converter = pet ->
            new AffiliatePetDto(pet.getRegNumber(), pet.getName(), pet.getAge(), pet
                    .getPetType(), pet.isAdopted());

    protected AffiliateRepository repository;

    protected AffiliatePetDto ConvertPetToAffiliatePetDto(Pet pet){
        return converter.convert(pet);
    }

    public abstract List<AffiliatePetDto> listPetsAddedByAffiliate(String email);
    public abstract AffiliateDto Register(Affiliate affiliate);
    public abstract Optional<Affiliate> CheckAffiliateByEmail(String email);
    public abstract boolean SignIn(String email, String password);
}
