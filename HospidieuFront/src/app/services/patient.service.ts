import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PatientInBed } from '../models/patientInBed.model';
import { Observable } from 'rxjs';
import { Patient } from '../models/patient.model';

@Injectable({
    providedIn: 'root'
})
export class PatientService {

    private baseUrl = "http://localhost:8080/patientsList";

    constructor(private http : HttpClient) {}

    getPatientsInBed() : Observable<PatientInBed[]> {
        return this.http.get<PatientInBed[]>(`${this.baseUrl}/in`);
    }

    getPatientsOut() : Observable<Patient[]> {
        return this.http.get<Patient[]>(`${this.baseUrl}/out`);
    }
}