package com.simplon.hospidieuBack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.DisplayPatientDto;
import com.simplon.hospidieuBack.model.Patient;

@Service
public class PatientConvert {

	public DisplayPatientDto convertDoToDto(Patient patient, Bed bed) {
		
		DisplayPatientDto displayedPatient = new DisplayPatientDto();
		
		displayedPatient.setId(patient.getIdPatient());
		displayedPatient.setName(patient.getName());
		displayedPatient.setFirstname(patient.getFirstname());
		displayedPatient.setDepartment(bed.getDepartment());
		displayedPatient.setRoom(bed.getRoomNumber());
		displayedPatient.setBed(bed.getBedNumber());
		
		return displayedPatient;
	}
	
//	public List<DisplayPatientDto> convertDoToDtoList(Patient[] patientList, Bed[] bedList) {
//		List<DisplayPatientDto> displayedPatientList = new ArrayList<>();
//		
//		for (int i = 0; i < patientList.length; i++) {
//			displayedPatientList.add(convertDoToDto(patientList[i], bedList[i]));
//		}
//		return displayedPatientList;
//	}
}
