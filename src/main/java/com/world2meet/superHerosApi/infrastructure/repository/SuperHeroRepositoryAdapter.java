package com.world2meet.superHerosApi.infrastructure.repository;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import com.world2meet.superHerosApi.domain.repository.SuperHeroRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuperHeroRepositoryAdapter implements SuperHeroRepositoryPort {

    @Override
    public SuperHero getSuperHeroById(SuperHero superHero) {
        return new SuperHero("Superman", "Clark Kent",
                "Kryptonian", "Metropolis");
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
