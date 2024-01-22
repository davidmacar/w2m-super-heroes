package com.world2meet.superHerosApi.application.usecase;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import com.world2meet.superHerosApi.domain.service.DeleteSuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSuperHeroServiceAdapter implements DeleteSuperHeroServicePort {

    @Override
    public void deleteSuperHero(SuperHero superHero) {

    }
}
