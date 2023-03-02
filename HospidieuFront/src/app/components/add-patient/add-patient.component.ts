import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators  } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.scss']
})
export class AddPatientComponent implements OnInit {

  patient : Patient = new Patient();
  form !: FormGroup;

  submitted = false;

  constructor(private patientService : PatientService, private router : Router, private formbuilder: FormBuilder) {}

  ngOnInit(): void {

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
      
  }

  savePatient(){
    this.patientService.createPatient(this.patient).subscribe( data =>{

    });
  }

  onSubmit(){
    if (this.form.valid) {
      console.log('form submitted');
      this.savePatient();
      this.router.navigateByUrl('/patientsList/out')
    } else {
      this.form.markAllAsTouched();
    }
    
  }
}
