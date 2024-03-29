package com.world2meet.superHeroesApi.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.model.response.AuthResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SuperHeroControllerIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void getAllSuperHeroesTest() throws Exception {
    String token = getToken();
    mockMvc
            .perform(
                    MockMvcRequestBuilders.get("/api/superheroes/getAllSuperHeroes")
                            .header("Authorization", "Bearer " + token))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                    MockMvcResultMatchers.content()
                            .string(
                                    "[{\"superHeroName\":\"Spiderman\",\"realName\":\"Peter Parker\",\"universe\":\"Marvel\",\"power\":\"Spider Sense\"},"
                                            + "{\"superHeroName\":\"Superman\",\"realName\":\"Clark Kent\",\"universe\":\"DC\",\"power\":\"Kryptonian\"},"
                                            + "{\"superHeroName\":\"Batman\",\"realName\":\"Bruce Wayne\",\"universe\":\"DC\",\"power\":\"Intelligence\"},"
                                            + "{\"superHeroName\":\"Wonder Woman\",\"realName\":\"Diana Prince\",\"universe\":\"DC\",\"power\":\"Amazonian\"},"
                                            + "{\"superHeroName\":\"Iron Man\",\"realName\":\"Tony Stark\",\"universe\":\"Marvel\",\"power\":\"Suit\"},"
                                            + "{\"superHeroName\":\"Captain America\",\"realName\":\"Steve Rogers\",\"universe\":\"Marvel\",\"power\":\"Super Soldier\"},"
                                            + "{\"superHeroName\":\"Black Widow\",\"realName\":\"Natasha Romanoff\",\"universe\":\"Marvel\",\"power\":\"Spy\"},"
                                            + "{\"superHeroName\":\"Hulk\",\"realName\":\"Bruce Banner\",\"universe\":\"Marvel\",\"power\":\"Strength\"},"
                                            + "{\"superHeroName\":\"Thor\",\"realName\":\"Thor Odinson\",\"universe\":\"Marvel\",\"power\":\"Asgardian\"},"
                                            + "{\"superHeroName\":\"Green Lantern\",\"realName\":\"Hal Jordan\",\"universe\":\"DC\",\"power\":\"Power Ring\"},"
                                            + "{\"superHeroName\":\"Flash\",\"realName\":\"Barry Allen\",\"universe\":\"DC\",\"power\":\"Speed\"},"
                                            + "{\"superHeroName\":\"Aquaman\",\"realName\":\"Arthur Curry\",\"universe\":\"DC\",\"power\":\"Atlantean\"},"
                                            + "{\"superHeroName\":\"Hawkeye\",\"realName\":\"Clint Barton\",\"universe\":\"Marvel\",\"power\":\"Marksmanship\"},"
                                            + "{\"superHeroName\":\"Cyborg\",\"realName\":\"Victor Stone\",\"universe\":\"DC\",\"power\":\"Cybernetic Enhancement\"},"
                                            + "{\"superHeroName\":\"Martian Manhunter\",\"realName\":\"J'onn J'onzz\",\"universe\":\"DC\",\"power\":\"Martian\"},"
                                            + "{\"superHeroName\":\"Black Panther\",\"realName\":\"T'Challa\",\"universe\":\"Marvel\",\"power\":\"Enhanced Senses\"},"
                                            + "{\"superHeroName\":\"Vision\",\"realName\":\"Vision\",\"universe\":\"Marvel\",\"power\":\"Density Control\"},"
                                            + "{\"superHeroName\":\"Scarlet Witch\",\"realName\":\"Wanda Maximoff\",\"universe\":\"Marvel\",\"power\":\"Chaos Magic\"},"
                                            + "{\"superHeroName\":\"Doctor Strange\",\"realName\":\"Stephen Strange\",\"universe\":\"Marvel\",\"power\":\"Sorcerer Supreme\"},"
                                            + "{\"superHeroName\":\"Ant-Man\",\"realName\":\"Scott Lang\",\"universe\":\"Marvel\",\"power\":\"Size Alteration\"},"
                                            + "{\"superHeroName\":\"Wasp\",\"realName\":\"Hope van Dyne\",\"universe\":\"Marvel\",\"power\":\"Size Alteration\"},"
                                            + "{\"superHeroName\":\"Black Canary\",\"realName\":\"Dinah Lance\",\"universe\":\"DC\",\"power\":\"Canary Cry\"},"
                                            + "{\"superHeroName\":\"Green Arrow\",\"realName\":\"Oliver Queen\",\"universe\":\"DC\",\"power\":\"Marksmanship\"},"
                                            + "{\"superHeroName\":\"Supergirl\",\"realName\":\"Kara Zor-El\",\"universe\":\"DC\",\"power\":\"Kryptonian\"},"
                                            + "{\"superHeroName\":\"Daredevil\",\"realName\":\"Matt Murdock\",\"universe\":\"Marvel\",\"power\":\"Enhanced Senses\"},"
                                            + "{\"superHeroName\":\"Punisher\",\"realName\":\"Frank Castle\",\"universe\":\"Marvel\",\"power\":\"Marksmanship\"},"
                                            + "{\"superHeroName\":\"Jessica Jones\",\"realName\":\"Jessica Jones\",\"universe\":\"Marvel\",\"power\":\"Super Strength\"},"
                                            + "{\"superHeroName\":\"Luke Cage\",\"realName\":\"Luke Cage\",\"universe\":\"Marvel\",\"power\":\"Super Strength\"},"
                                            + "{\"superHeroName\":\"Iron Fist\",\"realName\":\"Danny Rand\",\"universe\":\"Marvel\",\"power\":\"Chi Manipulation\"},"
                                            + "{\"superHeroName\":\"Star-Lord\",\"realName\":\"Peter Quill\",\"universe\":\"Marvel\",\"power\":\"Marksmanship\"},"
                                            + "{\"superHeroName\":\"Gamora\",\"realName\":\"Gamora\",\"universe\":\"Marvel\",\"power\":\"Assassin\"},"
                                            + "{\"superHeroName\":\"Rocket Raccoon\",\"realName\":\"Rocket\",\"universe\":\"Marvel\",\"power\":\"Marksmanship\"},"
                                            + "{\"superHeroName\":\"Groot\",\"realName\":\"Groot\",\"universe\":\"Marvel\",\"power\":\"Regeneration\"},"
                                            + "{\"superHeroName\":\"Drax the Destroyer\",\"realName\":\"Drax\",\"universe\":\"Marvel\",\"power\":\"Strength\"},"
                                            + "{\"superHeroName\":\"Mantis\",\"realName\":\"Mantis\",\"universe\":\"Marvel\",\"power\":\"Empathy\"},"
                                            + "{\"superHeroName\":\"Nebula\",\"realName\":\"Nebula\",\"universe\":\"Marvel\",\"power\":\"Cybernetic Enhancement\"},"
                                            + "{\"superHeroName\":\"Yondu\",\"realName\":\"Yondu Udonta\",\"universe\":\"Marvel\",\"power\":\"Yaka Arrow Control\"},"
                                            + "{\"superHeroName\":\"Shazam\",\"realName\":\"Billy Batson\",\"universe\":\"DC\",\"power\":\"Magic\"},"
                                            + "{\"superHeroName\":\"Black Adam\",\"realName\":\"Teth-Adam\",\"universe\":\"DC\",\"power\":\"Magic\"},"
                                            + "{\"superHeroName\":\"Hawkman\",\"realName\":\"Carter Hall\",\"universe\":\"DC\",\"power\":\"Reincarnation\"},"
                                            + "{\"superHeroName\":\"Hawkgirl\",\"realName\":\"Shiera Hall\",\"universe\":\"DC\",\"power\":\"Reincarnation\"},"
                                            + "{\"superHeroName\":\"Zatanna\",\"realName\":\"Zatanna Zatara\",\"universe\":\"DC\",\"power\":\"Magic\"},"
                                            + "{\"superHeroName\":\"John Constantine\",\"realName\":\"John Constantine\",\"universe\":\"DC\",\"power\":\"Magic\"},"
                                            + "{\"superHeroName\":\"Swamp Thing\",\"realName\":\"Alec Holland\",\"universe\":\"DC\",\"power\":\"Elemental Control\"},"
                                            + "{\"superHeroName\":\"Deadman\",\"realName\":\"Boston Brand\",\"universe\":\"DC\",\"power\":\"Spirit\"},"
                                            + "{\"superHeroName\":\"Spectre\",\"realName\":\"Jim Corrigan\",\"universe\":\"DC\",\"power\":\"Spirit\"},"
                                            + "{\"superHeroName\":\"Etrigan the Demon\",\"realName\":\"Jason Blood\",\"universe\":\"DC\",\"power\":\"Demon\"},"
                                            + "{\"superHeroName\":\"Raven\",\"realName\":\"Rachel Roth\",\"universe\":\"DC\",\"power\":\"Empathy\"},"
                                            + "{\"superHeroName\":\"Starfire\",\"realName\":\"Koriand'r\",\"universe\":\"DC\",\"power\":\"Energy Projection\"},"
                                            + "{\"superHeroName\":\"Beast Boy\",\"realName\":\"Garfield Logan\",\"universe\":\"DC\",\"power\":\"Shape Shifting\"}]"));
  }

  @Test
  void getSuperHeroeByIdTest() throws Exception {
    String token = getToken();
    SuperHeroRequest request = new SuperHeroRequest();
    request.setSuperHeroName("Spiderman");
    mockMvc
            .perform(
                    MockMvcRequestBuilders.post("/api/superheroes/getSuperHeroById")
                            .contentType(MediaType.APPLICATION_JSON)
                            .header("Authorization", "Bearer " + token)
                            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                    MockMvcResultMatchers.content()
                            .string(
                                    "{\"superHeroName\":\"Spiderman\",\"realName\":\"Peter Parker\",\"universe\":\"Marvel\",\"power\":\"Spider Sense\"}"));
  }

  @Test
  void getSuperHeroesContainingNameTest() throws Exception {
    String token = getToken();
    SuperHeroRequest request = new SuperHeroRequest();
    request.setContainedInName("man");
    mockMvc
            .perform(
                    MockMvcRequestBuilders.post("/api/superheroes/getSuperHeroesContainingInName")
                            .contentType(MediaType.APPLICATION_JSON)
                            .header("Authorization", "Bearer " + token)
                            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                    MockMvcResultMatchers.content()
                            .string(
                                    "[{\"superHeroName\":\"Spiderman\",\"realName\":\"Peter Parker\",\"universe\":\"Marvel\",\"power\":\"Spider Sense\"},"
                                            + "{\"superHeroName\":\"Superman\",\"realName\":\"Clark Kent\",\"universe\":\"DC\",\"power\":\"Kryptonian\"},"
                                            + "{\"superHeroName\":\"Batman\",\"realName\":\"Bruce Wayne\",\"universe\":\"DC\",\"power\":\"Intelligence\"},"
                                            + "{\"superHeroName\":\"Wonder Woman\",\"realName\":\"Diana Prince\",\"universe\":\"DC\",\"power\":\"Amazonian\"},"
                                            + "{\"superHeroName\":\"Iron Man\",\"realName\":\"Tony Stark\",\"universe\":\"Marvel\",\"power\":\"Suit\"},"
                                            + "{\"superHeroName\":\"Aquaman\",\"realName\":\"Arthur Curry\",\"universe\":\"DC\",\"power\":\"Atlantean\"},"
                                            + "{\"superHeroName\":\"Martian Manhunter\",\"realName\":\"J'onn J'onzz\",\"universe\":\"DC\",\"power\":\"Martian\"},"
                                            + "{\"superHeroName\":\"Ant-Man\",\"realName\":\"Scott Lang\",\"universe\":\"Marvel\",\"power\":\"Size Alteration\"},"
                                            + "{\"superHeroName\":\"Mantis\",\"realName\":\"Mantis\",\"universe\":\"Marvel\",\"power\":\"Empathy\"},"
                                            + "{\"superHeroName\":\"Hawkman\",\"realName\":\"Carter Hall\",\"universe\":\"DC\",\"power\":\"Reincarnation\"},"
                                            + "{\"superHeroName\":\"Deadman\",\"realName\":\"Boston Brand\",\"universe\":\"DC\",\"power\":\"Spirit\"}]"));
  }

  @Test
  void modifySuperHeroTest() throws Exception {
    String token = getToken();
    SuperHeroDto request = new SuperHeroDto();
    request.setSuperHeroName("Spiderman");
    request.setRealName("Miles Morales");
    request.setUniverse("La Tierra");
    request.setPower("Spider Web");
    mockMvc
            .perform(
                    MockMvcRequestBuilders.put("/api/superheroes/modifySuperHero")
                            .header("Authorization", "Bearer " + token)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(
                    MockMvcResultMatchers.content()
                            .string(
                                    "{\"superHeroName\":\"Spiderman\",\"realName\":\"Miles Morales\",\"universe\":\"La Tierra\",\"power\":\"Spider Web\"}"
                            ));
  }

  @Test
  void deleteSuperHeroTest() throws Exception {
    String token = getToken();
    SuperHeroRequest request = new SuperHeroRequest();
    request.setSuperHeroName("Spiderman");
    mockMvc
            .perform(
                    MockMvcRequestBuilders.delete("/api/superheroes/deleteSuperHero")
                            .header("Authorization", "Bearer " + token)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(request)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(result -> {
              mockMvc
                      .perform(
                              MockMvcRequestBuilders.post("/api/superheroes/getSuperHeroById")
                                      .header("Authorization", "Bearer " + token)
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(new ObjectMapper().writeValueAsString(request)))
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(
                              MockMvcResultMatchers.content()
                                      .string(
                                              ""
                                      ));;
            }) ;
  }

  private String getToken() throws Exception {
    MvcResult result =
            mockMvc
                    .perform(
                            MockMvcRequestBuilders.post("/api/auth/login")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{\"username\":\"davidmacar\",\"password\":\"davidmacar\"}"))
                    .andReturn();
    String str = result.getResponse().getContentAsString();
    AuthResponse authResponse = new ObjectMapper().readValue(str, AuthResponse.class);
    return authResponse.getToken();
  }
}
