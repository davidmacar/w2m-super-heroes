package com.world2meet.superHeroesApi.domain.model.request;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperHeroRequest {
    @JsonSetter(nulls = Nulls.SKIP)
    private String superHeroName="";
    @JsonSetter(nulls = Nulls.SKIP)
    private String containedInName="";
}
