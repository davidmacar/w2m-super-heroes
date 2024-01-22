package com.world2meet.superHerosApi.domain.repository;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

public interface SuperHeroRepositoryPort {

    @Cacheable("getSuperHeroById") // Almacenar la respuesta en la cache para evitar llamadas al método
    SuperHero getSuperHeroById(SuperHero superHero);

    List<SuperHero> getAllSuperHeroes();

    List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero);
}
