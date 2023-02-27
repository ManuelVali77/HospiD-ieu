package com.simplon.hospidieuBack.services;

import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.MonitoringDto;

public interface AddCommentService {
	
	void saveNewMonitoring(MonitoringDto monitoringDto);
	
	Monitoring convertMonitoringDtoToDo(MonitoringDto monitoringDto);
}
