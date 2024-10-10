package com.akram.livres.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	/*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*/@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws
	Exception {
	 auth.userDetailsService(userDetailsService)
	.passwordEncoder(bCryptPasswordEncoder);
	 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
     http.csrf(csrf -> csrf.disable());
     http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
 
 

//consulter tous les produits

http.authorizeHttpRequests().requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER");

//consulter un produit par son id

http.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority("ADMIN","USER");

//ajouter un nouveau produit
http.authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/**").hasAuthority("ADMIN");

//modifier un produit
http.authorizeHttpRequests().requestMatchers(HttpMethod.PUT, "/api/**").hasAuthority("ADMIN");

//supprimer un produit
http.authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/api/**").hasAuthority("ADMIN");

//login
http.authorizeHttpRequests().requestMatchers("/login").permitAll();
//afficher tous les utilisateurs
http.authorizeHttpRequests().requestMatchers("/allUsers").hasAuthority("ADMIN");

http.authorizeHttpRequests().anyRequest().authenticated();

http.addFilter(new JWTAuthenticationFilter (authenticationManager())) ;

http.addFilter(new JWTAuthenticationFilter (authenticationManager())) ;


http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

 }
}
