package com.simplon.hospidieuBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.MonitoringDto;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.repository.MonitoringRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;

@Service
public class AddCommentServiceImpl implements AddCommentService {

	@Autowired
	private MonitoringRepository monitoringRepo;
	
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public void saveNewMonitoring(MonitoringDto monitoringDto) {
		monitoringRepo.save(convertMonitoringDtoToDo(monitoringDto));
	}
	
	@Override
	public Monitoring convertMonitoringDtoToDo(MonitoringDto monitoringDto) {
		Monitoring monitoring = new Monitoring();

		monitoring.setComment(monitoringDto.getComment());
		monitoring.setSymptom(monitoringDto.getSymptom());
		monitoring.setDate(monitoringDto.getDate());

		Patient patient = patientRepo.findPatientsByIdPatient(monitoringDto.getIdPatient());
		monitoring.setPatient(patient);
		
		// TODO ajouter le User après la création du repo
//		User user = userRepo.findUsersById(monitoringDto.getIdUser());
//		monitoring.setUser(user);
		
		return monitoring;
	}
}
