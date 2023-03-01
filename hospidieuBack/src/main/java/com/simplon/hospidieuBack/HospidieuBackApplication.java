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

@SpringBootApplication
public class HospidieuBackApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Bienvenue sur HospiD'ieu ===");	
	}

}
