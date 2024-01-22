package com.world2meet.superHerosApi.infrastructure.controller;

import com.world2meet.superHerosApi.domain.model.SuperHero;
import com.world2meet.superHerosApi.domain.service.DeleteSuperHeroServicePort;
import com.world2meet.superHerosApi.domain.service.GetSuperHeroServicePort;
import com.world2meet.superHerosApi.domain.service.ModifySuperHeroServicePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/superheros")
@AllArgsConstructor
public class SuperHeroController {

    @Autowired
    private final GetSuperHeroServicePort getSuperHeroServicePort;

    @Autowired
    private final DeleteSuperHeroServicePort deleteSuperHeroServicePort;

    @Autowired
    private final ModifySuperHeroServicePort modifySuperHeroServicePort;

    @PostMapping("/getAllSuperHeroes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllSuperHeroes(@RequestBody SuperHero superHero) {
        return ResponseEntity.ok(this.getSuperHeroServicePort.getAllSuperHeroes());
    }

    @PostMapping("/getSuperHeroById")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getSuperHeroById(@RequestBody SuperHero superHero) {
        return ResponseEntity.ok(this.getSuperHeroServicePort.getSuperHeroById(superHero));
    }

    @PostMapping("/getSuperHeroesContainingInName")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getSuperHeroesContainingInName(@RequestBody SuperHero superHero) {
        return ResponseEntity.ok(this.getSuperHeroServicePort.getSuperHeroesContainingInName(superHero));
    }

    @PutMapping("/modifySuperHero")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifySuperHero(@RequestBody SuperHero superHero) {
        this.modifySuperHeroServicePort.modifySuperHero(superHero);
        return ResponseEntity.ok("SuperHero modified");
    }

    @DeleteMapping("/deleteSuperHero")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteSuperHero(@RequestBody SuperHero superHero) {
        this.deleteSuperHeroServicePort.deleteSuperHero(superHero);
        return ResponseEntity.ok("SuperHero deleted");
    }

}
