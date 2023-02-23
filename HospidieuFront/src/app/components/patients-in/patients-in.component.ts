import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patients-in',
  templateUrl: './patients-in.component.html',
  styleUrls: ['./patients-in.component.scss']
})
export class PatientsInComponent implements OnInit{

  patientsList !: Patient[];

  constructor(private patientService : PatientService, private router : Router) {}

  ngOnInit(): void {
    this.patientService.getPatientsInBed().subscribe((data : Patient[]) => {
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

  onGoToPatient(id : number) : void {
    // TODO : changer l'URL
    console.log(id);
    this.router.navigateByUrl("patient/" + id);
  }

}
