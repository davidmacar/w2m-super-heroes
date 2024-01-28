package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.annotation.LogExecutionTime;
import com.world2meet.superHeroesApi.domain.model.SuperHero;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.GetSuperHeroServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GetSuperHeroServiceAdapter implements GetSuperHeroServicePort {

    private final SuperHeroRepositoryPort superHeroRepositoryPort;

    @Override
    @LogExecutionTime
    public SuperHero getSuperHeroById(SuperHero superHero) {
        return this.superHeroRepositoryPort.getSuperHeroById(superHero);
    }

    @Override
    @LogExecutionTime
    public List<SuperHero> getAllSuperHeroes() {
        return this.superHeroRepositoryPort.getAllSuperHeroes();
    }

    @Override
    @LogExecutionTime
    public List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero) {
        return null;
    }
}
