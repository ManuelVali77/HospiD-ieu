package com.simplon.hospidieuBack.services;

import java.util.List;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;

public interface AdmissionService {

	List<Bed> getEmptyBeds();
	Bed getBedById(int idBed);
	Patient getPatientById(int idPatient);
	void admitPatientToBed(PatientInBedDto patientInBed);
	void dismissPatientFromBed(PatientInBedDto patientInBed);
	void addInOutMonitoring(PatientInBedDto patientDto, String condition);
}
