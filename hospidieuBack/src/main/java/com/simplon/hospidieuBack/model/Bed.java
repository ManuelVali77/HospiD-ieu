package com.simplon.hospidieuBack.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "beds")
public class Bed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBed;
	
	private int bedNumber;
	private int roomNumber;
	private String department;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_patient")
	private Patient patient;

	@Override
	public String toString() {
		return "Bed [idBed=" + idBed + ", bedNumber=" + bedNumber + ", roomNumber=" + roomNumber + ", department="
				+ department + ", patient=" + patient + "]";
	}

	// Getters/setters
	public int getIdBed() {
		return idBed;
	}

	public void setIdBed(int bedId) {
		this.idBed = bedId;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
