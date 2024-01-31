package com.world2meet.superHeroesApi.authentication.repository;

import com.world2meet.superHeroesApi.authentication.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    User login(User user);

    void register(User user);

}