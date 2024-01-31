package com.world2meet.superHeroesApi.domain.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

public interface SuperHeroRepositoryPort {

    @Cacheable("getSuperHeroById") // Almacenar la respuesta en la cache para evitar llamadas al método
    SuperHeroDto getSuperHeroById(SuperHeroDto superHero);

    List<SuperHeroDto> getAllSuperHeroes();

    List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroDto superHero);
}
