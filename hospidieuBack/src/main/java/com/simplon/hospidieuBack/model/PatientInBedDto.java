package com.simplon.hospidieuBack.model;

/**
 * DTO to display Patients infos in the patients list
 * @author S. Lebrun
 *
 */
public class PatientInBedDto {
	

	private int idPatient;
	private String name;
	private String firstname;
	private String department;
	private int room;
	private int bed;
	private int idBed;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		PatientInBedDto that = (PatientInBedDto) obj;
		return idPatient == that.idPatient && name.equals(that.name) && firstname.equals(that.firstname) && department.equals(that.department) && room == that.room && bed == that.bed && idBed == that.idBed;
	}
	
	// Getters/setters
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int id) {
		this.idPatient = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	
	public int getIdBed() {
		return idBed;
	}

	public void setIdBed(int idBed) {
		this.idBed = idBed;
	}
	
	public String toString() {
		return "Le patient " + this.name + " " + this.firstname + " est au service " + this.department + " chambre n°" + this.room + " lit " + this.bed;
	}
}
