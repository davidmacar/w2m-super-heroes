package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.service.DeleteSuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSuperHeroServiceAdapter implements DeleteSuperHeroServicePort {

    @Override
    public void deleteSuperHero(SuperHeroDto superHero) {

    }
}
