package com.world2meet.superHerosApi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SuperHero{

    private String name;
    private String superHeroName;
    private String universe;
    private String power;
}
