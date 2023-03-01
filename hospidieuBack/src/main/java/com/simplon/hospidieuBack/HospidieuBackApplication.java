package com.simplon.hospidieuBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.hospidieuBack.repository.PatientRepository;

@SpringBootApplication
public class HospidieuBackApplication  implements CommandLineRunner {
	
	@Autowired
	PatientRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Bienvenue sur HospiD'ieu ===");
		System.out.println(repo.findPatientsByIdPatient(1));
	}

}
