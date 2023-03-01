package com.simplon.hospidieuBack.services;

import java.util.List;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;

public interface AdmissionService {

	List<Bed> getEmptyBeds();
	void admitPatientToBed(PatientInBedDto patientInBed);
	Bed getBedById(int idBed);
	Patient getPatientById(int idPatient);
}
