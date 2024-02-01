package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;

public interface ModifySuperHeroServicePort {

        public SuperHeroDto  modifySuperHero(SuperHeroRequest request);
}
