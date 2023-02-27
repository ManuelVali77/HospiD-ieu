package com.simplon.hospidieuBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class AddPatientServiceImpl implements AddPatientService {
	
	@Autowired
	private PatientRepository patientRepo;

    public AddPatientServiceImpl(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

	@Override
	public void addPatient(Patient patient) {	
		System.out.println(patient);
        patientRepo.save(patient);
    }

}
