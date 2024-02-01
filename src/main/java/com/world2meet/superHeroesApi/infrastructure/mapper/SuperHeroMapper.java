package com.world2meet.superHeroesApi.infrastructure.mapper;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SuperHeroMapper {
    public List<SuperHeroDto> getAllSuperHeroes();
    public List<SuperHeroDto> getSuperHeroesContainingInName(String name);
    public SuperHeroDto getSuperHeroById(String id);
    public void deleteSuperHero(String id);

    public void modifySuperHero(SuperHeroDto superHeroDto);
}
