package com.world2meet.superHerosApi.application.usecase;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import com.world2meet.superHerosApi.domain.service.ModifySuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModifySuperHeroServiceAdapter implements ModifySuperHeroServicePort {

    @Override
    public void modifySuperHero(SuperHero superHero) {

    }
}
