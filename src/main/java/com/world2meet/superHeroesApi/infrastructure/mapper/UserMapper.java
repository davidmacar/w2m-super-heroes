package com.world2meet.superHeroesApi.infrastructure.mapper;

import com.world2meet.superHeroesApi.domain.model.User;

public interface UserMapper {

    void login(User user);
    void register(User user);

}
