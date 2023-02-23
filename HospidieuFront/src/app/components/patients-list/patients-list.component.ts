import { Component, OnInit } from '@angular/core';
import { PatientInBed } from '../../models/patientInBed.model';
import { PatientService } from '../../services/patient.service';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.scss']
})
export class PatientsListComponent implements OnInit {

  patientsList !: PatientInBed[];

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.patientService.getPatientsInBed().subscribe((data : PatientInBed[]) => {
      console.log(data);
      this.patientsList = data;
    })
  }

}
