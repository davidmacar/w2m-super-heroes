package com.world2meet.superHeroesApi.infrastructure.repository;

import com.world2meet.superHeroesApi.domain.model.UserDto;
import com.world2meet.superHeroesApi.domain.repository.UserRepositoryPort;
import com.world2meet.superHeroesApi.infrastructure.mapper.UserMapper;
import java.util.Optional;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserMapper userMapper;
    
    @Override
    public Optional<UserDto> findByUsername(String username) {
        UserDto user = this.userMapper.findByUsername(username);
        return Optional.ofNullable(user);
    }

    @Override
    public void register(UserDto user) {
        Logger.getLogger("UserRepositoryAdapter").info("User " + user.getUsername() + " registered");
        this.userMapper.register(user);
    }

}
