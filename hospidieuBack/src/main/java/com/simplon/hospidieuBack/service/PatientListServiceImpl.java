package com.simplon.hospidieuBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.InformationDto;
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.MonitoringRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class PatientListServiceImpl implements PatientListService {

	@Autowired
	private BedRepository bedRepo;
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private MonitoringRepository monitoRepo;
	
	@Autowired
	private InformationConvert infoServ;
	
	@Autowired 
	private PatientConvert patientConv;
	
	@Override
	public List<InformationDto> getMonitoringByPatient(int idPatient){
		Patient patient = new Patient();
		patient.setIdPatient(idPatient);
		List<Monitoring> monitorings =  this.monitoRepo.findMonitoringsByPatient(patient);
		
		return infoServ.convertInfoDoToDtoList(monitorings);
	}
	
	@Override
	public PatientInBedDto getBedsWithPatientId(int idPatient) {
		Patient patient = new Patient();
		patient.setIdPatient(idPatient);
		
		Bed bed = bedRepo.findBedsByPatient(patient);
		if(bed == null) {
			Patient patientNotBed = patientRepo.findPatientsByIdPatient(idPatient);
			return patientConv.convertPatientDoToDto(patientNotBed);
		}
		return patientConv.convertBedDoToDto(bed);
	}

	@Override
	public List<PatientInBedDto> getBedsWithPatients() {
		List<Bed> bedsWithPatients = bedRepo.findByPatientIsNotNull();
		return this.patientConv.convertDoToDtoList(bedsWithPatients);
	}

	@Override
	public List<Patient> getInactivePatients() {
		List<Bed> bedWithPatientsList = bedRepo.findByPatientIsNotNull();
		List<Patient> patientsList = patientRepo.findAll();
		for (Bed bedWithPatient : bedWithPatientsList) {
			patientsList.remove(bedWithPatient.getPatient());
		}
		return patientsList;
	}

	@Override
	public Patient getPatient(int id) {
		Patient patient = patientRepo.findPatientsByIdPatient(id);
		return patient;
	}
}
