package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHero;
import com.world2meet.superHeroesApi.domain.service.ModifySuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModifySuperHeroServiceAdapter implements ModifySuperHeroServicePort {

    @Override
    public void modifySuperHero(SuperHero superHero) {

    }
}
