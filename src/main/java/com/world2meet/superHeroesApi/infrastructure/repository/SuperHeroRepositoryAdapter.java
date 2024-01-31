package com.world2meet.superHeroesApi.infrastructure.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.infrastructure.mapper.SuperHeroMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SuperHeroRepositoryAdapter implements SuperHeroRepositoryPort {

    @Autowired
    private final SuperHeroMapper superHeroMapper;

    @Override
    public SuperHeroDto getSuperHeroById(SuperHeroDto superHero) {
        return new SuperHeroDto("Superman", "Clark Kent",
                "Kryptonian", "Metropolis");
    }

    @Override
    public List<SuperHeroDto> getAllSuperHeroes() {
        return this.superHeroMapper.getAllSuperHeroes();
    }

    @Override
    public List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroDto superHero) {
        return null;
    }
}
