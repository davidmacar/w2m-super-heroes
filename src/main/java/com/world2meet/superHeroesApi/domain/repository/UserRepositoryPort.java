package com.world2meet.superHeroesApi.domain.repository;


import com.world2meet.superHeroesApi.domain.model.User;

public interface UserRepositoryPort {

    public void login(User user);
    public void register();
}
