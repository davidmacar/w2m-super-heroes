package com.world2meet.superHeroesApi.authentication.repository;


import com.world2meet.superHeroesApi.authentication.model.User;
import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findByUsername(String username);
    public void register(User user);

}
