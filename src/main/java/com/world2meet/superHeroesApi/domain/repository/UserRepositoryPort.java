package com.world2meet.superHeroesApi.domain.repository;

import com.world2meet.superHeroesApi.domain.model.UserDto;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<UserDto> findByUsername(String username);

    void register(UserDto user);
}
