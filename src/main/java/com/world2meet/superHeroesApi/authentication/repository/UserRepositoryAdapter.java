package com.world2meet.superHeroesApi.authentication.repository;

import com.world2meet.superHeroesApi.authentication.model.User;
import java.util.Optional;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserMapper userMapper;
    
    @Override
    public Optional<User> findByUsername(String username) {
        User user = this.userMapper.findByUsername(username);
        return Optional.ofNullable(user);
    }

    @Override
    public void register(User user) {
        Logger.getLogger("UserRepositoryAdapter").info("User " + user.getUsername() + " registered");
        this.userMapper.register(user);
    }

}
