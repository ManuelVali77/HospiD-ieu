package com.simplon.hospidieuBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.services.PatientConvert;
import com.simplon.hospidieuBack.services.PatientListService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/patientsList")
public class PatientController {

	@Autowired
	private PatientListService patientListService;
	
	@Autowired
	private PatientConvert patientConvert;
	
	@GetMapping("in")
	public List<PatientInBedDto> getAllPatientsInBeds() {
		List<Bed> bedsWithPatients = this.patientListService.getBedsWithPatients();
		return this.patientConvert.convertDoToDtoList(bedsWithPatients);
	}

	@GetMapping("out")
	public List<Patient> getAllInactivePatients() {
		return this.patientListService.getInactivePatients();
	}
}
