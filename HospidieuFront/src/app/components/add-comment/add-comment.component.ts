import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Monitoring } from 'src/app/models/monitoring.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent implements OnInit {

  idPatient !: number;
  commentForm !: FormGroup;
  monitoring !: Monitoring;
  isSubmitted !: boolean;

  constructor (private route : ActivatedRoute, private formBuilder : FormBuilder, private service : PatientService) {}

  ngOnInit(): void {
    this.idPatient = this.route.snapshot.params['id'];

    this.isSubmitted = false;

    this.commentForm = this.formBuilder.group({
      comment : ['', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(200)]],
      symptom : ['', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50)]]
    })
  }

  onSubmit() : void {
    this.isSubmitted = true;

    if (this.commentForm.valid) {
      const data = this.commentForm.value;
      
      this.monitoring = {
        comment : data["comment"],
        symptom : data["symptom"],
        idPatient : this.idPatient,
        date : new Date()
      }
      
      this.service.saveMonitoring(this.monitoring).subscribe(() => console.log("Envoyé"));
    } else {
      console.log("Non envoyé");
    }
  }

}
