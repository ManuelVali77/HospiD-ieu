import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PatientInBed } from '../models/patientInBed';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class PatientService {

    private baseUrl = "http://localhost:8080/patientsList";

    constructor(private http : HttpClient) {}

    getPatientsInBed() : Observable<PatientInBed[]> {
        return this.http.get<PatientInBed[]>(`${this.baseUrl}`);
    }
}