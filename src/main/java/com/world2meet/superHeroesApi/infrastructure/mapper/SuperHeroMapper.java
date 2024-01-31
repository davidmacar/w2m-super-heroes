package com.world2meet.superHeroesApi.infrastructure.mapper;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SuperHeroMapper {
    List<SuperHeroDto> getAllSuperHeroes();
}
