package com.simplon.hospidieuBack;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.hospidieuBack.controller.PatientController;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;

@SpringBootApplication
public class HospidieuBackApplication implements CommandLineRunner {
	
	@Autowired
	PatientController controller;

	@Autowired
	BedRepository bedRepo;
	@Autowired
	PatientRepository patientRepo;

	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bienvenue sur HospiD'ieu");
		System.out.println("Patients admis :");
		for (PatientInBedDto patientToDisplay : this.controller.getAllPatientsInBeds()) {
			System.out.println(patientToDisplay);
		}
		System.out.println("Patients sortis :");
		for (Patient patientToDisplay : this.controller.getAllInactivePatients()) {
			System.out.println(patientToDisplay);
		}
	}

}
