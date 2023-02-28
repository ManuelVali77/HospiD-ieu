package com.simplon.hospidieuBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	private BedRepository bedRepo;
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public List<Bed> getEmptyBeds() {
		return bedRepo.findByPatientIsNull();
	}
	

	@Override
	public Patient getPatientById(int idPatient) {
		return patientRepo.findPatientsByIdPatient(idPatient);
	}

	@Override
	public Bed getBedById(int idBed) {
		return bedRepo.findBedsByIdBed(idBed);
	}
	
	@Override
	public void admitPatientToBed(PatientInBedDto patientInBed) {
		Patient patient = getPatientById(patientInBed.getIdPatient());
		Bed bed = getBedById(patientInBed.getIdBed());
		
		bed.setPatient(patient);
		bedRepo.save(bed);
	}
}
