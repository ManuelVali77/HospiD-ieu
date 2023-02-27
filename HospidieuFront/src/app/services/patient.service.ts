import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../models/patient.model';

@Injectable({
    providedIn: 'root'
})
export class PatientService {

  private baseURL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  createPatient(patient: Patient): Observable<Object>{
    return this.httpClient.post<Patient>(this.baseURL+'/addPatient', patient);
  }
  getPatientById(id : number) : Observable<Patient> {
    return this.httpClient.get<Patient>(`${this.baseURL}patient/${id}`);
  }

  getPatientsInBed() : Observable<Patient[]> {
      return this.httpClient.get<Patient[]>(`${this.baseURL}patientsList/in`);
  }

  getPatientsOut() : Observable<Patient[]> {
      return this.httpClient.get<Patient[]>(`${this.baseURL}patientsList/out`);
  }
}