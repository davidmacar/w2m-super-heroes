package com.world2meet.superHeroesApi.domain.repository;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import java.util.List;

public interface SuperHeroRepositoryPort {

  SuperHeroDto getSuperHeroById(String id);

  List<SuperHeroDto> getAllSuperHeroes();

  List<SuperHeroDto> getSuperHeroesContainingInName(String name);

  void deleteSuperHero(String id);

  void modifySuperHero(SuperHeroDto superHeroDto);
}
