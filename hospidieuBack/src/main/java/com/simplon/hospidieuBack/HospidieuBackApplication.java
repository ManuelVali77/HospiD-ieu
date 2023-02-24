package com.simplon.hospidieuBack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplon.hospidieuBack.controller.PatientController;
import com.simplon.hospidieuBack.controller.PatientListController;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.repository.BedRepository;

@SpringBootApplication
public class HospidieuBackApplication implements CommandLineRunner {
	
	@Autowired
	PatientListController controller;
	
	@Autowired
	PatientController patientController;
	
	@Autowired
	BedRepository bedRepo;

	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Bienvenue sur HospiD'ieu");
//		for (PatientInBedDto patientToDisplay : this.controller.getAllPatientsInBeds()) {
//			System.out.println(patientToDisplay);
//		}
		
//		patientController.addPatient("Valinhas", "Manuel", "2920-12-12", "rue blabla", "59100", "Roubaix", "0630030303", 3333333);
		
	}

}
