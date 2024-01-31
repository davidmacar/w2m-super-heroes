package com.world2meet.superHeroesApi.domain.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHero;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

public interface SuperHeroRepositoryPort {

    @Cacheable("getSuperHeroById") // Almacenar la respuesta en la cache para evitar llamadas al método
    SuperHero getSuperHeroById(SuperHero superHero);

    List<SuperHero> getAllSuperHeroes();

    List<SuperHero> getSuperHeroesContainingInName(SuperHero superHero);
}
