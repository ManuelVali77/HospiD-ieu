package com.simplon.hospidieuBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.services.PatientConvert;
import com.simplon.hospidieuBack.services.PatientListService;
import com.simplon.hospidieuBack.services.AddPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

	@Autowired
	private PatientListService patientListService;
	
	@Autowired
	private PatientConvert patientConvert;

	@Autowired
	private AddPatientService addPatientService;
	
	@GetMapping("patientsList/in")
	public List<PatientInBedDto> getAllPatientsInBeds() {
		List<Bed> bedsWithPatients = this.patientListService.getBedsWithPatients();
		return this.patientConvert.convertDoToDtoList(bedsWithPatients);
	}

	@GetMapping("patientsList/out")
	public List<Patient> getAllInactivePatients() {
		return this.patientListService.getInactivePatients();
	}

	@PostMapping("addPatient")
	public void addPatient(@RequestBody Patient patient) {
		
		 this.addPatientService.addPatient(patient);
	}
}

