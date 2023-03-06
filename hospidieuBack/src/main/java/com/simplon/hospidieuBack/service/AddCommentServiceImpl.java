package com.simplon.hospidieuBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.MonitoringDto;
import com.simplon.hospidieuBack.repository.MonitoringRepository;

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
