package com.simplon.hospidieuBack.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "monitorings")
public class Monitoring implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMonitoring;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_patient")
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User user;
	
	private String comment;
	private String symptom;
	private Date date;
	
	// Getters/setters
	public int getIdMonitoring() {
		return idMonitoring;
	}
	public void setIdMonitoring(int idMonitoring) {
		this.idMonitoring = idMonitoring;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
