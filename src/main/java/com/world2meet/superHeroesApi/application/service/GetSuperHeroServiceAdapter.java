package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.GetSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.utils.LogExecutionTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetSuperHeroServiceAdapter implements GetSuperHeroServicePort {

    private final SuperHeroRepositoryPort superHeroRepositoryPort;

    @Override
    @Cacheable("SuperHeroesCache")
    @LogExecutionTime
    public List<SuperHeroDto> getAllSuperHeroes() {
        return this.superHeroRepositoryPort.getAllSuperHeroes();
    }

    @Override
    @Cacheable("SuperHeroesCache")
    @LogExecutionTime
    public List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroRequest request) {
        return this.superHeroRepositoryPort.getSuperHeroesContainingInName(request.getContainedInName());
    }

    @Override
    @Cacheable("SuperHeroesCache")
    @LogExecutionTime
    public SuperHeroDto getSuperHeroById(SuperHeroRequest request) {
        return this.superHeroRepositoryPort.getSuperHeroById(request.getSuperHeroName());
    }
}
