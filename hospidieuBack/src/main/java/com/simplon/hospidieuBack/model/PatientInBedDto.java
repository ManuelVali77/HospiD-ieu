package com.simplon.hospidieuBack.model;

/**
 * DTO to display Patients infos in the patients list
 * @author S. Lebrun
 *
 */
public class PatientInBedDto {
	
	private int id;
	private String name;
	private String firstname;
	private String department;
	private int room;
	private int bed;
	
	// Getters/setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String toString() {
		return "Le patient " + this.name + " " + this.firstname + " est au service " + this.department + " chambre n°" + this.room + " lit " + this.bed;
	}
}
