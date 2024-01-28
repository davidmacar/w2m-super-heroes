package com.world2meet.superHeroesApi.infrastructure.mapper;

import com.world2meet.superHeroesApi.domain.model.SuperHero;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuperHeroMapper {
    List<SuperHero> getAllSuperHeroes();
}
