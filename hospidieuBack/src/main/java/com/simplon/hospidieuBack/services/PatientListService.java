package com.simplon.hospidieuBack.services;

import java.util.List;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;

public interface PatientListService {

	List<Bed> getAllBeds();
	List<Patient> getAllPatients();
	List<Bed> getBedsWithPatients();
	List<Patient> getInactivePatients();
	Patient getPatient(int id);
}
