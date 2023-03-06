package com.simplon.hospidieuBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.MonitoringDto;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.repository.PatientRepository;
import com.simplon.hospidieuBack.repository.UserRepository;

@Service
public class MonitoringConvert {

	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private UserRepository userRepo;
	
	public Monitoring convertMonitoringDtoToDo(MonitoringDto monitoringDto) {
		Monitoring monitoring = new Monitoring();

		monitoring.setComment(monitoringDto.getComment());
		monitoring.setSymptom(monitoringDto.getSymptom());
		monitoring.setDate(monitoringDto.getDate());

		Patient patient = patientRepo.findPatientsByIdPatient(monitoringDto.getIdPatient());
		monitoring.setPatient(patient);
		
		User user = userRepo.findByMail(monitoringDto.getUserMail());
		monitoring.setUser(user);
		
		return monitoring;
	}
	
}
