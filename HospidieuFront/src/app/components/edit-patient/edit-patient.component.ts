import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators  } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.scss']
})

export class EditPatientComponent {
  patient : Patient = new Patient();
  form !: FormGroup;
  patientId !: number;

  submitted = false;

  ID_patient ?: number;
  name !: string;
  firstname !: string;
  birthDate !: Date;
  address !: string;
  postcode !: number;
  city !: string;
  phone !: number;
  securityNumber !: string;
  dialogConfig: any;

  constructor(private route : ActivatedRoute,private patientService : PatientService, private router : Router, private formbuilder: FormBuilder) {

  }
  
  ngOnInit(): void {

      this.patientId = this.route.snapshot.params['id'];
    //   this.name = this.name;

    this.form = this.formbuilder.group({
      name: ['', Validators.required],
      firstname: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postcode: ['', Validators.required],
      birthDate: ['', Validators.required],
      securityNumber: ['', Validators.required],
      phone: ['', Validators.required],
    });

    this.patientService.getPatient(this.patientId).subscribe((data: Patient) => {
      console.log(data);
      this.patient = data;
      
  });

  }

  savePatient(){
    console.log(this.patient);
    this.patientService.createPatient(this.patient).subscribe(() =>
      console.log("envoyé"));
  }

  onSubmit(){
    if (this.form.valid) {
      console.log('form submitted');
      this.savePatient();
      this.form.reset();
    } else {
      this.form.markAllAsTouched();
    }
    
  }
  updatePatient(){

  }

}
