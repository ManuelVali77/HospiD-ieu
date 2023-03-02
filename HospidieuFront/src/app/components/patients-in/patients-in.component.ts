import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientAndBed } from 'src/app/models/patient-and-bed.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patients-in',
  templateUrl: './patients-in.component.html',
  styleUrls: ['./patients-in.component.scss']
})
export class PatientsInComponent implements OnInit{

  patientsList !: PatientAndBed[];
  title = 'Angular Search Using ng2-search-filter';
  @Input() searchText!: any;

  constructor(private patientService : PatientService, private router : Router) {}

  ngOnInit(): void {
    this.patientService.getPatientsInBed().subscribe((data : PatientAndBed[]) => {
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
    this.router.navigateByUrl("patient/" + id+"/history");
  }

}
