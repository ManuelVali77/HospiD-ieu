package com.simplon.hospidieuBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class PatientListServiceImpl implements PatientListService {

	@Autowired
	private PatientRepository patientRepo;
	
	public List<Patient> getAllPatients() {
		return this.patientRepo.findAll();
	}
}
