package com.world2meet.superHeroesApi.infrastructure.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.infrastructure.mapper.SuperHeroMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SuperHeroRepositoryAdapter implements SuperHeroRepositoryPort {

    private final SuperHeroMapper superHeroMapper;

    @Override
    public SuperHeroDto getSuperHeroById(String id) {
        return this.superHeroMapper.getSuperHeroById(id);
    }

    @Override
    public List<SuperHeroDto> getAllSuperHeroes() {
        return this.superHeroMapper.getAllSuperHeroes();
    }

    @Override
    public List<SuperHeroDto> getSuperHeroesContainingInName(String name) {
        return this.superHeroMapper.getSuperHeroesContainingInName(name);
    }

    @Override
    public void deleteSuperHero(String id) {
        this.superHeroMapper.deleteSuperHero(id);
    }

    @Override
    public void modifySuperHero(SuperHeroDto superHeroDto) {
    this.superHeroMapper.modifySuperHero(superHeroDto);
    }
}
