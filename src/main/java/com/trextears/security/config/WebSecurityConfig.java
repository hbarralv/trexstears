package com.trextears.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    /**
     * Solo se permiten peticiones autenticadas con el tipo HTTPBasic
     * @param http
     * @throws Exception
     */
   @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
       return http.build();
   }

    /**
     * Creamos una instancia de el BcryptPassword encoder para encriptar y desencrptar las contraseñàs
     * @return
     */
   @Bean
   public PasswordEncoder encoder(){
       return new BCryptPasswordEncoder();
   }


    /**
     * Generamos un usuario en memoria con la contraseña encriptada(Bcrypt) y un rol de admin
     * @param auth
     * @throws Exception
     */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
       auth.inMemoryAuthentication()
               .withUser("admin")
               .password("$2a$12$657yl7p643ZMqs5uhl9VIOEixF6SJzZ8QgYLMqdV5FVcZVkJg.3AK").roles("admin");
  }
}