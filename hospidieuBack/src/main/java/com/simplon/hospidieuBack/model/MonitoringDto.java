package com.simplon.hospidieuBack.model;

import java.util.Date;

public class MonitoringDto {
	
	private String comment;
	private String symptom;
	private Date date;
	private int idPatient;
	private String userMail;
	
	// Getters-setters
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
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setIdUser(String userMail) {
		this.userMail = userMail;
	}

}
