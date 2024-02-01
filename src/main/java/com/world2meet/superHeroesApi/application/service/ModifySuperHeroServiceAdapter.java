package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.service.ModifySuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModifySuperHeroServiceAdapter implements ModifySuperHeroServicePort {

    @Override
    public SuperHeroDto  modifySuperHero(SuperHeroRequest request) {
        return null;
    }
}
