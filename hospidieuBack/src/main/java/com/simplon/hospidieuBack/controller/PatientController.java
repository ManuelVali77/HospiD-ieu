package com.simplon.hospidieuBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.InformationDto;
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.MonitoringDto;
import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.services.AddCommentService;
import com.simplon.hospidieuBack.services.PatientConvert;
import com.simplon.hospidieuBack.services.PatientListService;
import com.simplon.hospidieuBack.services.AddPatientService;
import com.simplon.hospidieuBack.services.AdmissionService;
import com.simplon.hospidieuBack.services.InformationConvert;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

	@Autowired
	private PatientListService patientListService;

	@Autowired
	private AddCommentService addCommentService;

	@Autowired
	private PatientConvert patientConvert;

	@Autowired
	private AddPatientService addPatientService;

	@Autowired
	private AdmissionService admissionService;

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

	@PostMapping("addPatient")
	public void addPatient(@RequestBody Patient patient) {

		this.addPatientService.addPatient(patient);
	}
	
	@GetMapping("patient/{idPatient}")
	public PatientInBedDto getPatientInBedById(@PathVariable("idPatient") String idPatient) {
		try {
			int id = Integer.parseInt(idPatient);
			return this.patientListService.getBedsWithPatientId(id);
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/admission")
	public List<Bed> getEmptyBeds() {
		return admissionService.getEmptyBeds();
	}

	@RequestMapping(value = { "/admission/{idPatient}" }, method = RequestMethod.GET)
	public Patient getPatientToAdmit(@PathVariable("idPatient") String inputId) {
		try {
			int id = Integer.parseInt(inputId);
			return admissionService.getPatientById(id);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("patient/{idPatient}/history")
	public List<InformationDto> getMonitoringByIdPatient(@PathVariable("idPatient") String idPatient) {
		try {
			int id = Integer.parseInt(idPatient);
			return this.patientListService.getMonitoringByPatient(id);
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		return null;
		
	}
	
	@PutMapping("admission/save")
	public void admitPatient(@RequestBody PatientInBedDto patientInBed) {
		admissionService.admitPatientToBed(patientInBed);
	}

	@PutMapping("dismiss")
	public void dismissPatient(@RequestBody PatientInBedDto patientInBed) {
		admissionService.dismissPatientFromBed(patientInBed);
	}
	
	@GetMapping("editPatient/{id}")
	public Patient getPatient(@PathVariable(value="id") int id) {
		return this.patientListService.getPatient(id);
	}
}
