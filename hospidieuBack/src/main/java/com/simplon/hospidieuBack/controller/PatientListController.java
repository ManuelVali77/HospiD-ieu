package com.simplon.hospidieuBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.services.PatientListService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientListController {

	@Autowired
	private PatientListService patientListService;
	
//	@GetMapping("patientsList")
	public List<PatientInBedDto> getAllPatientsInBeds() {
		return this.patientListService.getAllPatientsInBeds();
	}
}
