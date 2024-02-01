package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.utils.LogExecutionTime;

import java.util.List;

public interface GetSuperHeroServicePort {


    public SuperHeroDto getSuperHeroById(SuperHeroRequest request);

    public List<SuperHeroDto> getAllSuperHeroes();

    public List<SuperHeroDto> getSuperHeroesContainingInName(SuperHeroRequest request);
}
