import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';

@Component({
  selector: 'app-patient-detail',
  templateUrl: './patient-detail.component.html',
  styleUrls: ['./patient-detail.component.scss']
})
export class PatientDetailComponent implements OnInit {

  @Input() patient !: Patient;
  id !: number;

  constructor(private route : ActivatedRoute, private router : Router) {}

  ngOnInit() : void {
    this.id = this.route.snapshot.params['id'];
  }

  onAddComment() : void {
    this.router.navigateByUrl("comment/" + this.id);
  }

}
