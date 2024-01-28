package com.world2meet.superHeroesApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SuperHerosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperHerosApplication.class, args);
    }

}
