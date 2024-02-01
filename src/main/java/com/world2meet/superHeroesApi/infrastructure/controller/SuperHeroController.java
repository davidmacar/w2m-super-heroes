package com.world2meet.superHeroesApi.infrastructure.controller;

import com.world2meet.superHeroesApi.application.validator.SuperHeroContainingNameValidator;
import com.world2meet.superHeroesApi.application.validator.SuperHeroDtoValidator;
import com.world2meet.superHeroesApi.application.validator.SuperHeroNameValdiator;
import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.service.DeleteSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.service.GetSuperHeroServicePort;
import com.world2meet.superHeroesApi.domain.service.ModifySuperHeroServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/superheroes")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "SuperHeroes API", description = "The Superheroes API")
public class SuperHeroController {

  private final GetSuperHeroServicePort getSuperHeroServicePort;
  private final DeleteSuperHeroServicePort deleteSuperHeroServicePort;
  private final ModifySuperHeroServicePort modifySuperHeroServicePort;

  private final SuperHeroNameValdiator superHeroNameValdiator = new SuperHeroNameValdiator();
  private final SuperHeroContainingNameValidator superHeroContainingNameValidator =
      new SuperHeroContainingNameValidator();
  private final SuperHeroDtoValidator superHeroDtoValidator = new SuperHeroDtoValidator();

  @GetMapping(value = "/getAllSuperHeroes", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      summary = "Retrieve all superheroes",
      description = "Retrieve all superheroes in DDBB",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Superheroes retrieved successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = SuperHeroDto.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Impossible to reach this endpoint without authentication",
            content = {@Content(mediaType = "application/json")})
      })
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<SuperHeroDto>> getAllSuperHeroes() {
    return ResponseEntity.ok(this.getSuperHeroServicePort.getAllSuperHeroes());
  }

  @PostMapping(
      value = "/getSuperHeroById",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      summary = "Retrieve Superhero by Id",
      description = "Use the \"superHeroName\" parameter to retrieve Superhero by his identity name",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Superhero retrieved successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = List.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "400",
            description = "Request parameters are invalid",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Impossible to reach this endpoint without authentication",
            content = {@Content(mediaType = "application/json")})
      })
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SuperHeroDto> getSuperHeroById(
      @RequestBody
          SuperHeroRequest request,
      BindingResult bindingResult)
      throws BadRequestException {
    this.validate(this.superHeroNameValdiator, request, bindingResult);
    return ResponseEntity.ok(this.getSuperHeroServicePort.getSuperHeroById(request));
  }

  @PostMapping(
      value = "/getSuperHeroesContainingInName",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      summary = "Retrieve all SuperHeroes containing a chain in \"superHeroName\"",
      description =
          "Use the \"containedInName\" parameter to retrieve all SuperHeroes containing in \"superHeroName\"",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "SuperHeroes  retrieved successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = SuperHeroDto.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "400",
            description = "Request parameters are invalid",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Impossible to reach this endpoint without authentication",
            content = {@Content(mediaType = "application/json")})
      })
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<SuperHeroDto>> getSuperHeroesContainingInName(
      @RequestBody
          SuperHeroRequest request,
      BindingResult bindingResult)
      throws BadRequestException {
    this.validate(this.superHeroContainingNameValidator, request, bindingResult);
    return ResponseEntity.ok(this.getSuperHeroServicePort.getSuperHeroesContainingInName(request));
  }

  @PutMapping(
      value = "/modifySuperHero",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      summary = "Modify Superhero",
      description =
          "Modify Superhero in DDBB by his \"superHeroName\" and with the values passed as request",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Superheroes updated successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = List.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "400",
            description = "Request parameters are invalid",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Impossible to reach this endpoint without authentication",
            content = {@Content(mediaType = "application/json")})
      })
  public ResponseEntity<SuperHeroDto> modifySuperHero(
      @RequestBody
          SuperHeroDto request,
      BindingResult bindingResult)
      throws BadRequestException {
    this.validate(this.superHeroDtoValidator, request, bindingResult);
    return ResponseEntity.ok(this.modifySuperHeroServicePort.modifySuperHero(request));
  }

  @DeleteMapping(
      value = "/deleteSuperHero",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
      summary = "Delete Superhero",
      description = "Delete Superhero in DDBB by his identity name",
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Superheroes deleted successfully",
            content = {
              @Content(
                  mediaType = "application/json",
                  array = @ArraySchema(schema = @Schema(implementation = List.class)))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "400",
            description = "Request parameters are invalid",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Impossible to reach this endpoint without authentication",
            content = {@Content(mediaType = "application/json")})
      })
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteSuperHero(
      @RequestBody
          SuperHeroRequest request,
      BindingResult bindingResult)
      throws BadRequestException {
    this.validate(this.superHeroNameValdiator, request, bindingResult);
    this.deleteSuperHeroServicePort.deleteSuperHero(request);
    return ResponseEntity.ok("Superhero deleted");
  }

  protected void validate(Validator validator, Object dto, BindingResult bindingResult)
      throws BadRequestException {
    if (null != validator) {
      ValidationUtils.invokeValidator(validator, dto, bindingResult);
      if (bindingResult.hasErrors()) {
        throw new BadRequestException(String.valueOf(bindingResult));
      }
    }
  }
}
