package com.simplon.hospidieuBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.services.AddPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {
	
	@Autowired
	private AddPatientService addPatientService;
	

	@PostMapping("addPatient")
	public void addPatient(@RequestBody Patient patient) {
		
		 this.addPatientService.addPatient(patient);
	}
}
