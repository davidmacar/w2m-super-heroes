package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.DeleteSuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSuperHeroServiceAdapter implements DeleteSuperHeroServicePort {
    private final SuperHeroRepositoryPort superHeroRepositoryPort;
    @Override
    @CacheEvict(value = "SuperHeroesCache", allEntries = true)
    public void deleteSuperHero(SuperHeroRequest request) {
        this.superHeroRepositoryPort.deleteSuperHero(request.getSuperHeroName());
    }
}
