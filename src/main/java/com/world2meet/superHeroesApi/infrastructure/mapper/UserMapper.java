package com.world2meet.superHeroesApi.infrastructure.mapper;

import com.world2meet.superHeroesApi.domain.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserDto findByUsername(String username);

    UserDto login(UserDto user);

    void register(UserDto user);

}