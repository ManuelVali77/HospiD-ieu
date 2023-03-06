package com.simplon.hospidieuBack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.InformationDto;
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.User;

@Service
public class InformationConvert {
	
	public InformationDto convertInformationDoToDto(Monitoring monitoring) {
		
		Patient patient = monitoring.getPatient();
		InformationDto information = new InformationDto();
		
		information.setDate(monitoring.getDate());
		information.setComment(monitoring.getComment());
		information.setSymptom(monitoring.getSymptom());
		
		information.setIdPatient(patient.getIdPatient());
		
		User user = monitoring.getUser();
		if (user != null) {			
			information.setIdUser(user.getIdUser());
			information.setUserFirstName(user.getFirstName());
			information.setUserName(user.getName());
		}

		return information;
	}
	
	public List<InformationDto> convertInfoDoToDtoList(List<Monitoring> monitorings) {
		List<InformationDto> listInfo = new ArrayList<>();
		for(Monitoring monitoring : monitorings) {
			listInfo.add(convertInformationDoToDto(monitoring));
		}
		return listInfo;
	}
}
