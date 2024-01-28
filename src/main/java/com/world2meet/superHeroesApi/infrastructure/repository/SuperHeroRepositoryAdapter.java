package com.world2meet.superHeroesApi.infrastructure.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHero;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.infrastructure.mapper.SuperHeroMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SuperHeroRepositoryAdapter implements SuperHeroRepositoryPort {

    @Autowired
    private final SuperHeroMapper superHeroMapper;

    @Override
    public SuperHero getSuperHeroById(SuperHero superHero) {
        return new SuperHero("Superman", "Clark Kent",
                "Kryptonian", "Metropolis");
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        return this.superHeroMapper.getAllSuperHeroes();
    }

    @Override
    public List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero) {
        return null;
    }
}
