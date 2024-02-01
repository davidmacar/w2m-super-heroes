package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.ModifySuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModifySuperHeroServiceAdapter implements ModifySuperHeroServicePort {

  private final SuperHeroRepositoryPort superHeroRepositoryPort;

  @Override
  @CacheEvict(value = "modifySuperHero", allEntries = true)
  public SuperHeroDto modifySuperHero(SuperHeroDto request) {
    this.superHeroRepositoryPort.modifySuperHero(request);
    return this.superHeroRepositoryPort.getSuperHeroById(request.getSuperHeroName());
  }
}
