package com.simplon.hospidieuBack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class PatientListServiceImpl implements PatientListService {

	@Autowired
	private BedRepository bedRepo;
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public List<Patient> getAllPatients() {
		return this.patientRepo.findAll();
	}

	@Override
	public List<Bed> getAllBeds() {
		return this.bedRepo.findAll();
	}

	@Override
	public List<Bed> getBedsWithPatients() {
		List<Bed> bedsList = getAllBeds();
		List<Bed> bedsWithPatientsList = new ArrayList<Bed>();
		for (Bed bed : bedsList) {
			if (bed.getPatient() instanceof Patient) {
				bedsWithPatientsList.add(bed);
			}
		}
		return bedsWithPatientsList;
	}

	@Override
	public List<Patient> getInactivePatients() {
		List<Bed> bedWithPatientsList = getBedsWithPatients();
		List<Patient> patientsList = getAllPatients();
		for (Bed bedWithPatient : bedWithPatientsList) {
			patientsList.remove(bedWithPatient.getPatient());
		}
		return patientsList;
	}
	
	
}
