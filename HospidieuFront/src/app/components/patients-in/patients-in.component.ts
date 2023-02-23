import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientInBed } from 'src/app/models/patientInBed.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patients-in',
  templateUrl: './patients-in.component.html',
  styleUrls: ['./patients-in.component.scss']
})
export class PatientsInComponent implements OnInit{

  patientsList !: PatientInBed[];

  constructor(private patientService : PatientService, private router : Router) {}

  ngOnInit(): void {
    this.patientService.getPatientsInBed().subscribe((data : PatientInBed[]) => {
      console.log(data);
      this.patientsList = data;
    })
  }

  onShowPatientsIn() : void {
    this.router.navigateByUrl("patientsList/in");
  }

  onShowPatientsOut() : void {
    this.router.navigateByUrl("patientsList/out");
  }

}
