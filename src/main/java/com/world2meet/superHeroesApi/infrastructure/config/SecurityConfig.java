package com.world2meet.superHeroesApi.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  //    @Bean
  //    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
  //        return httpSecurity
  //                // Disable Cross Site Request Forgery (CSRF) al no trabajar con formularios web
  // no será necesaria
  //                .csrf().disable()
  //                .authorizeHttpRequests( requests -> {
  //                    // Se permite el acceso sin seguridad a index
  //                    requests.requestMatchers(new
  // AntPathRequestMatcher("/superheros/index2")).permitAll();
  //                    // Cualquier otra petición requiere autenticación
  ////                    requests.anyRequest().authenticated();
  //                    })
  //                .formLogin().permitAll()
  //                .and().build();
  //    }

      @Bean
      public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
          return httpSecurity
                  .csrf().disable()
                  .authorizeHttpRequests()
                  .anyRequest()
                      .permitAll()
                  .and()
                  .build();
      }


}
