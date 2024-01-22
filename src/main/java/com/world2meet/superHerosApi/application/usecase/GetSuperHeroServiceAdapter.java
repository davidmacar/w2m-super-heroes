package com.world2meet.superHerosApi.application.usecase;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import com.world2meet.superHerosApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHerosApi.domain.service.GetSuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetSuperHeroServiceAdapter implements GetSuperHeroServicePort {

    private final SuperHeroRepositoryPort superHeroRepositoryPort;

    @Override
    public SuperHero getSuperHeroById(SuperHero superHero) {
        return this.superHeroRepositoryPort.getSuperHeroById(superHero);
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        return null;
    }

    @Override
    public List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero) {
        return null;
    }
}
