package com.simplon.hospidieuBack.service;

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
	private MonitoringConvert convert;

	@Override
	public void saveNewMonitoring(MonitoringDto monitoringDto) {
		monitoringRepo.save(convert.convertMonitoringDtoToDo(monitoringDto));
	}
	
}
