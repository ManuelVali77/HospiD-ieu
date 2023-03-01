package com.simplon.hospidieuBack.services;

import java.util.List;
import java.util.Optional;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.InformationDto;
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;

public interface PatientListService {

	List<Bed> getAllBeds();
	List<Patient> getAllPatients();
	List<Bed> getBedsWithPatients();
	List<Patient> getInactivePatients();
	List<InformationDto> getMonitoringByPatient(int idPatient);
	PatientInBedDto getBedsWithPatientId(int patientId);
}
