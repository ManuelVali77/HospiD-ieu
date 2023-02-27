import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../models/patient.model';
import { Monitoring } from '../models/monitoring.model';
import { PatientAndBed } from '../models/patient-and-bed.model';

@Injectable({
    providedIn: 'root'
})
export class PatientService {

  private baseUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  createPatient(patient: Patient): Observable<Object>{
    return this.http.post<Patient>(this.baseUrl+'addPatient', patient);
  }
  getPatientById(id : number) : Observable<PatientAndBed> {
    return this.http.get<PatientAndBed>(`${this.baseUrl}patient/${id}`);
  }

  getPatientsInBed() : Observable<PatientAndBed[]> {
      return this.http.get<PatientAndBed[]>(`${this.baseUrl}patientsList/in`);
  }

    getPatientsOut() : Observable<PatientAndBed[]> {
        return this.http.get<PatientAndBed[]>(`${this.baseUrl}patientsList/out`);
    }

    saveMonitoring(monitoring : Monitoring) : Observable<Monitoring> {
        return this.http.post<Monitoring>(`${this.baseUrl}comment/save`, monitoring);
    }
}