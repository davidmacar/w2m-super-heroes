package com.world2meet.superHeroesApi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SuperHeroDto {
    private String superHeroName;
    private String realName;
    private String universe;
    private String power;
}
