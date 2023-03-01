package com.simplon.hospidieuBack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.model.Patient;

@Service
public class PatientConvert {

	public PatientInBedDto convertBedDoToDto(Bed bed) {
		
		Patient patient = bed.getPatient();
		
		PatientInBedDto displayedPatient = new PatientInBedDto();
		
		displayedPatient.setIdPatient(patient.getIdPatient());
		displayedPatient.setName(patient.getName());
		displayedPatient.setFirstname(patient.getFirstname());
		displayedPatient.setDepartment(bed.getDepartment());
		displayedPatient.setRoom(bed.getRoomNumber());
		displayedPatient.setBed(bed.getBedNumber());
		
		return displayedPatient;
	}
	
	public List<PatientInBedDto> convertDoToDtoList(List<Bed> patientsList) {
		List<PatientInBedDto> displayedPatientList = new ArrayList<>();
		
		for (Bed bed : patientsList) {
			displayedPatientList.add(convertBedDoToDto(bed));
		}
		return displayedPatientList;
	}
	
	public PatientInBedDto convertPatientDoToDto(Patient patient) {
		
		PatientInBedDto displayedPatient = new PatientInBedDto();
		displayedPatient.setIdPatient(patient.getIdPatient());
		displayedPatient.setName(patient.getName());
		displayedPatient.setFirstname(patient.getFirstname());
		
		return displayedPatient;
	}
}
