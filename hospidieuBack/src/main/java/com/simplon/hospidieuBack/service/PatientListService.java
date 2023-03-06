package com.simplon.hospidieuBack.service;

import java.util.List;

import com.simplon.hospidieuBack.model.InformationDto;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;

public interface PatientListService {

	List<PatientInBedDto> getBedsWithPatients();
	List<Patient> getInactivePatients();
	Patient getPatient(int id);
	List<InformationDto> getMonitoringByPatient(int idPatient);
	PatientInBedDto getBedsWithPatientId(int patientId);
}
