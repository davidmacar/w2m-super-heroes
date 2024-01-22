package com.world2meet.superHerosApi.domain.service;

import com.world2meet.superHerosApi.domain.model.SuperHero;

import java.util.List;

public interface GetSuperHeroServicePort {

    public SuperHero getSuperHeroById(SuperHero superHero);

    public List<SuperHero> getAllSuperHeroes();

    public List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero);
}
