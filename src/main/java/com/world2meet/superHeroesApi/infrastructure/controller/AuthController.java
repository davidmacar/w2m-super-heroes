package com.world2meet.superHeroesApi.infrastructure.controller;

import com.world2meet.superHeroesApi.domain.model.request.AuthRequest;
import com.world2meet.superHeroesApi.domain.model.response.AuthResponse;
import com.world2meet.superHeroesApi.domain.service.AuthenticatorServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticatorServicePort authService;
    @PostMapping("/login")
    @DeleteMapping(
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Login to get the JWT related to user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User logged in successfully",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = List.class)))
                            }),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = {
                                    @Content(
                                            mediaType = "application/json")
                            })
            }
    )
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(this.authService.login(request));
    }

    @PostMapping("/register")
    @DeleteMapping(
            value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Register the user in BBDD and get a JWT",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User registered successfully",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = List.class)))
                            }),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = {
                                    @Content(
                                            mediaType = "application/json")
                            })
            }
    )
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
            return ResponseEntity.ok(this.authService.register(request));
    }

}
