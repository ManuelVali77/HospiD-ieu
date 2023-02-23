import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patients-out',
  templateUrl: './patients-out.component.html',
  styleUrls: ['./patients-out.component.scss']
})
export class PatientsOutComponent {

  patientsList !: Patient[];

  constructor(private patientService : PatientService, private router : Router) {}

  ngOnInit(): void {
    this.patientService.getPatientsOut().subscribe((data : Patient[]) => {
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
