package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import com.world2meet.superHeroesApi.domain.repository.SuperHeroRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class GetSuperHeroServiceAdapterTest {

  @InjectMocks private GetSuperHeroServiceAdapter getSuperHeroServiceAdapterUnderTest;
  @Mock private SuperHeroRepositoryPort superHeroRepositoryPort;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getAllSuperHeroes() {
    Exception ex = null;
    List<SuperHeroDto> lista = new ArrayList<SuperHeroDto>();
    lista.add(new SuperHeroDto());
    try {
      Mockito.when(this.superHeroRepositoryPort.getAllSuperHeroes()).thenReturn(lista);
      List<SuperHeroDto> result = this.getSuperHeroServiceAdapterUnderTest.getAllSuperHeroes();
      Assertions.assertEquals(lista, result);
    } catch (Exception e) {
      ex = e;
    }
    Assertions.assertNull(ex);
  }

  @Test
  void getSuperHeroesContainingInName() {
      Exception ex = null;
      List<SuperHeroDto> lista = new ArrayList<SuperHeroDto>();
      lista.add(new SuperHeroDto());
      SuperHeroRequest superHeroRequest = new SuperHeroRequest();
        superHeroRequest.setContainedInName("man");
      try {
          Mockito.when(this.superHeroRepositoryPort.getSuperHeroesContainingInName("man")).thenReturn(lista);
          List<SuperHeroDto> result = this.getSuperHeroServiceAdapterUnderTest.getSuperHeroesContainingInName(superHeroRequest);
          Assertions.assertEquals(lista, result);
      } catch (Exception e) {
          ex = e;
      }
      Assertions.assertNull(ex);
  }

  @Test
  void getSuperHeroById() {
      Exception ex = null;
      SuperHeroRequest superHeroRequest = new SuperHeroRequest();
      superHeroRequest.setSuperHeroName("spiderman");
      SuperHeroDto dto = new SuperHeroDto();
      dto.setSuperHeroName("batman");
      try {
          Mockito.when(this.superHeroRepositoryPort.getSuperHeroById("spiderman")).thenReturn(dto);
          SuperHeroDto result =
                  this.getSuperHeroServiceAdapterUnderTest.getSuperHeroById(superHeroRequest);
          Assertions.assertEquals("batman", result.getSuperHeroName());
      } catch (Exception e) {
          ex = e;
      }
      Assertions.assertNull(ex);
  }
}
