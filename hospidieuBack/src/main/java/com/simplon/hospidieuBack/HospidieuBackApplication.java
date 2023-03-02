package com.simplon.hospidieuBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.hospidieuBack.controller.PatientController;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.MonitoringRepository;
import com.simplon.hospidieuBack.services.PatientListService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HospidieuBackApplication  implements CommandLineRunner {
	
	@Autowired
	PatientController control;
	
	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Bienvenue sur HospiD'ieu ===");	
	}
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
