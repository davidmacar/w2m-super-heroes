package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import java.util.List;

public interface GetSuperHeroServicePort {

    public SuperHeroDto getSuperHeroById(SuperHeroDto superHero);

    public List<SuperHeroDto> getAllSuperHeroes();

    public List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroDto superHero);
}
