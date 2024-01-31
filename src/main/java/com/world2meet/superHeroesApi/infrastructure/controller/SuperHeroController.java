package com.world2meet.superHeroesApi.infrastructure.controller;

import com.world2meet.superHeroesApi.domain.model.SuperHero;
import com.world2meet.superHeroesApi.domain.service.DeleteSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.service.GetSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.service.ModifySuperHeroServicePort;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/superheroes")
@SecurityRequirement(name = "bearerAuth")
public class SuperHeroController {

    private final GetSuperHeroServicePort getSuperHeroServicePort;

    private final DeleteSuperHeroServicePort deleteSuperHeroServicePort;

    private final ModifySuperHeroServicePort modifySuperHeroServicePort;


    @GetMapping("/getAllSuperHeroes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllSuperHeroes() {
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
