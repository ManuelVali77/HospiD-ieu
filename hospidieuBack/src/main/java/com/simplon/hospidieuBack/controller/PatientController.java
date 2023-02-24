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
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.MonitoringDto;
import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.services.AddCommentService;
import com.simplon.hospidieuBack.services.PatientConvert;
import com.simplon.hospidieuBack.services.PatientListService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

	@Autowired
	private PatientListService patientListService;
	
	@Autowired
	private AddCommentService addCommentService;
	
	@Autowired
	private PatientConvert patientConvert;
	
	@GetMapping("patientsList/in")
	public List<PatientInBedDto> getAllPatientsInBeds() {
		List<Bed> bedsWithPatients = this.patientListService.getBedsWithPatients();
		return this.patientConvert.convertDoToDtoList(bedsWithPatients);
	}

	@GetMapping("patientsList/out")
	public List<Patient> getAllInactivePatients() {
		return this.patientListService.getInactivePatients();
	}
	
	@PostMapping("comment/save")
	public void saveMonitoring(@RequestBody MonitoringDto newMonitoring) {
		this.addCommentService.saveNewMonitoring(newMonitoring);
	}
}
