package com.simplon.hospidieuBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import com.simplon.hospidieuBack.repository.UserRepository;
//import com.simplon.hospidieuBack.security.CustomUserDetailsService;
import com.simplon.hospidieuBack.security.JwtAuthenticationEntryPoint;
import com.simplon.hospidieuBack.security.JwtTokenFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

//    @Autowired
//    private CustomUserDetailsService userDetailsService;
    @Autowired
	JwtAuthenticationEntryPoint authenticationEntryPoint;
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    	return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/patientsList/in").permitAll()
                                .requestMatchers("/patientsList/out").permitAll()
                                .requestMatchers("/addPatient").permitAll()
                                .requestMatchers("/addUser").permitAll()
                                .requestMatchers("/user").permitAll()
    					.anyRequest().authenticated()
                        
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/patientsList/in", true)
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );

		http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);		
        return http.build();
    }
    
	@Bean
	public JwtTokenFilter jwtTokenFilter(){
		return new JwtTokenFilter();
	}
	
}

