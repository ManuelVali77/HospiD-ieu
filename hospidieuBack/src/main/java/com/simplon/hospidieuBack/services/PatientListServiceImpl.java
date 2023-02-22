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
	
	@Autowired
	private PatientConvert patientConvert;
	
	public List<Patient> getAllPatients() {
		return this.patientRepo.findAll();
	}
	
	public List<Bed> getAllBeds() {
		return this.bedRepo.findAll();
	}
	
	public List<PatientInBedDto> getAllPatientsInBeds() {
		List<Bed> patientsList = getAllBeds();
		List<Bed> patientsInBedList = new ArrayList<Bed>();
		for (Bed bed : patientsList) {
			if (bed.getPatient() instanceof Patient) {
				patientsInBedList.add(bed);
			}
		}
		return this.patientConvert.convertDoToDtoList(patientsInBedList);
	}
}
