import { Component, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PatientAndBed } from 'src/app/models/patient-and-bed.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-remove-from-bed',
  templateUrl: './remove-from-bed.component.html',
  styleUrls: ['./remove-from-bed.component.scss']
})
export class RemoveFromBedComponent {

  @Input() patient !: PatientAndBed;

  constructor(
    private dialogRef : MatDialogRef<RemoveFromBedComponent>,
    private patientService : PatientService,
    @Inject(MAT_DIALOG_DATA) public parentData: {patient: PatientAndBed}
  ) {}

  ngOnInit() : void {
    this.patient = this.parentData.patient;
    console.log(this.parentData);
    console.log(this.patient);
  }

  onConfirm() : void {
    this.patientService.dismissPatient(this.patient).subscribe(() => 
    window.location.reload());
    this.dialogRef.close();
  }

  onCancel() : void {
    this.dialogRef.close();
  }

}
