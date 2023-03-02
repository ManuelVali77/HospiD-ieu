package com.simplon.hospidieuBack.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Monitoring;
import com.simplon.hospidieuBack.model.Patient;
import com.simplon.hospidieuBack.model.PatientInBedDto;
import com.simplon.hospidieuBack.model.User;
import com.simplon.hospidieuBack.repository.BedRepository;
import com.simplon.hospidieuBack.repository.MonitoringRepository;
import com.simplon.hospidieuBack.repository.PatientRepository;
import com.simplon.hospidieuBack.repository.UserRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService {
	
	@Autowired
	private BedRepository bedRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private MonitoringRepository monitoringRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Bed> getEmptyBeds() {
		return bedRepo.findByPatientIsNull();
	}
	

	@Override
	public Patient getPatientById(int idPatient) {
		return patientRepo.findPatientsByIdPatient(idPatient);
	}

	@Override
	public Bed getBedById(int idBed) {
		return bedRepo.findBedsByIdBed(idBed);
	}
	
	@Override
	public void admitPatientToBed(PatientInBedDto patientInBed) {
		Patient patient = getPatientById(patientInBed.getIdPatient());
		Bed bed = getBedById(patientInBed.getIdBed());
		
		bed.setPatient(patient);
		bedRepo.save(bed);
		
		addInOutMonitoring(patientInBed, "admis au");
	}
	
	@Override
	public void dismissPatientFromBed(PatientInBedDto patientInBed) {
		Bed bed = getBedById(patientInBed.getIdBed());
		bed.setPatient(null);
		bedRepo.save(bed);
		
		addInOutMonitoring(patientInBed, "sorti du");
	}
	
	@Override
	public void addInOutMonitoring(PatientInBedDto patientDto, String condition) {
		Monitoring monitoring = new Monitoring();
		monitoring.setDate(new Date());
		
		Patient patient = patientRepo.findPatientsByIdPatient(patientDto.getIdPatient());
		monitoring.setPatient(patient);
		
		User user = userRepo.findByMail(patientDto.getUserMail());
		monitoring.setUser(user);
		
		monitoring.setComment("Patient " + condition + " service " + patientDto.getDepartment() + ", chambre " + patientDto.getRoom() + " lit " + patientDto.getBed());
		
		monitoringRepo.save(monitoring);
	}
}
