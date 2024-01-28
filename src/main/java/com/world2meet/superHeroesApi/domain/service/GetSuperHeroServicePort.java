package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.SuperHero;

import java.util.List;

public interface GetSuperHeroServicePort {

    public SuperHero getSuperHeroById(SuperHero superHero);

    public List<SuperHero> getAllSuperHeroes();

    public List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero);
}
