package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.GetSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.utils.LogExecutionTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GetSuperHeroServiceAdapter implements GetSuperHeroServicePort {

    private final SuperHeroRepositoryPort superHeroRepositoryPort;

    @Override
    @LogExecutionTime
    public SuperHeroDto getSuperHeroById(SuperHeroDto superHero) {
        return this.superHeroRepositoryPort.getSuperHeroById(superHero);
    }

    @Override
    @LogExecutionTime
    public List<SuperHeroDto> getAllSuperHeroes() {
        return this.superHeroRepositoryPort.getAllSuperHeroes();
    }

    @Override
    @LogExecutionTime
    public List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroDto superHero) {
        return null;
    }
}
