package com.world2meet.superHeroesApi.infrastructure.config;

import com.world2meet.superHeroesApi.domain.repository.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class ApplicationConfig {

    private final UserRepositoryPort userRepository;

    /**
     * AuthenticationManager.
     * Creación de un AuthenticationManager que se encargará de la gestionar la autenticación de los usuarios.
     * @param config
     * @return AuthenticationManager
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

    /**
     * AuthenticationProvider.
     * Creación de un AuthenticationProvider que se proveer la autenticación de los usuarios.
     * Usará el UserDetailsService para obtener los datos del usuario y el PasswordEncoder para ecnriptar la contraseña.
     * @return AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    /**
     * PasswordEncoder.
     * Creación de un PasswordEncoder que se encargará de encriptar la contraseña.
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * UserDetailsService.
     * Creación de un UserDetailsService que se encargará de obtener los datos del usuario.
     * @return UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailService() {
        return username -> this.userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not fournd"));
    }
}
