import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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

  constructor (private route : ActivatedRoute, private formBuilder : FormBuilder, private service : PatientService) {}

  ngOnInit(): void {
    this.idPatient = this.route.snapshot.params['id'];

    this.commentForm = this.formBuilder.group({
      comment : [''],
      symptom : ['']
    })
  }

  onSubmit() : void {
    const data = this.commentForm.value;

    this.monitoring = {
      comment : data["comment"],
      symptom : data["symptom"],
      idPatient : this.idPatient,
      date : new Date()
    }

    this.service.saveMonitoring(this.monitoring).subscribe();
  }

}
