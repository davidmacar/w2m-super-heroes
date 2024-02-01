package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;

public interface DeleteSuperHeroServicePort {

    public void deleteSuperHero(SuperHeroRequest request);
}
