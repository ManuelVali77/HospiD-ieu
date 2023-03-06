package com.simplon.hospidieuBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.Patient;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Integer> {
	
	List<Monitoring> findMonitoringsByPatient(Patient patient);

}
