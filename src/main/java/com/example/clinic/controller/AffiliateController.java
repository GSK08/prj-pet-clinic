package com.example.clinic.controller;

import com.example.clinic.Dtos.AffiliateDto;
import com.example.clinic.Dtos.AffiliatePetDto;
import com.example.clinic.Requests.AffiliateRegisterRequest;
import com.example.clinic.Requests.AffiliateSignInRequest;
import com.example.clinic.facade.AppFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/affiliate")
public class AffiliateController {
    private final AppFacade appFacade;

    public AffiliateController(AppFacade appFacade) {
        this.appFacade = appFacade;
    }

    @PostMapping
    public ResponseEntity<AffiliateDto> register(@RequestBody AffiliateRegisterRequest request){
        return appFacade.signUp(request);
    }

    @GetMapping("/pets")
    public List<AffiliatePetDto> getPetsAddedByAffiliate(@RequestParam String affiliateMail){
        return appFacade.listAffiliatePets(affiliateMail);
    }

    @GetMapping
    public boolean signIn(@RequestBody AffiliateSignInRequest request){
        return appFacade.singIn(request);
    }
}
