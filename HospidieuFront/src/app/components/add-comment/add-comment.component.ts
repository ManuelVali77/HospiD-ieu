import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Monitoring } from 'src/app/models/monitoring.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent implements OnInit {

  element !: any;
  idPatient !: number;
  commentForm !: FormGroup;
  monitoring !: Monitoring;
  isSubmitted !: boolean;

  constructor (
    private formBuilder : FormBuilder,
    private patientService : PatientService,
    private dialogRef : MatDialogRef<AddCommentComponent>,
    @Inject(MAT_DIALOG_DATA) public parentData: {patientId: number}
    ) {}

  ngOnInit(): void {
    this.idPatient = this.parentData.patientId;

    this.commentForm = this.formBuilder.group({
      comment : ['', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(200)]],
      symptom : ['', [
        Validators.minLength(3),
        Validators.maxLength(50)]]
    })
  }

  onSubmit() : void {

    if (this.commentForm.valid) {
      const data = this.commentForm.value;
      console.log(data);
      
      this.monitoring = {
        comment : data["comment"],
        symptom : data["symptom"],
        idPatient : this.idPatient,
        date : new Date(),
        userMail : sessionStorage.getItem('mail')
      }
      console.log(this.monitoring);
      
      this.patientService.saveMonitoring(this.monitoring).subscribe(() =>
      window.location.reload());
      this.dialogRef.close();
    } else {
      this.commentForm.markAllAsTouched();
      console.log("Non envoyé");
    }
  }

  onClose() {
    this.dialogRef.close();
  }

}
