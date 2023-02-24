import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../models/patient.model';

@Injectable({
    providedIn: 'root'
})
export class PatientService {

    private baseUrl = "http://localhost:8080/";

    constructor(private http : HttpClient) {}

    getPatientById(id : number) : Observable<Patient> {
        return this.http.get<Patient>(`${this.baseUrl}patient/${id}`);
    }

    getPatientsInBed() : Observable<Patient[]> {
        return this.http.get<Patient[]>(`${this.baseUrl}patientsList/in`);
    }

    getPatientsOut() : Observable<Patient[]> {
        return this.http.get<Patient[]>(`${this.baseUrl}patientsList/out`);
    }
}