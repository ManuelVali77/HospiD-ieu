import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientAndBed } from 'src/app/models/patient-and-bed.model';
import { AddCommentComponent } from '../add-comment/add-comment.component';
import { RemoveFromBedComponent } from '../remove-from-bed/remove-from-bed.component';

@Component({
  selector: 'app-patient-detail',
  templateUrl: './patient-detail.component.html',
  styleUrls: ['./patient-detail.component.scss']
})
export class PatientDetailComponent implements OnInit {

  @Input() patient !: PatientAndBed;
  patientId !: number;

  // Modal component :
  dialogConfig = new MatDialogConfig();
  modalComment : MatDialogRef<AddCommentComponent, any> | undefined;
  modalOuting : MatDialogRef<RemoveFromBedComponent, any> | undefined;

  constructor(private route : ActivatedRoute, private router : Router, private matDialog : MatDialog) {}

  ngOnInit() : void {
    this.patientId = this.route.snapshot.params['id'];
    this.patient = {
      idPatient : this.patientId,
      name : "Nom",
      firstname : "Prénom",
      phone : "0333333333",
      birthDate : new Date('1992-06-28'),
      idBed : 2
    }
  }

  // // To close the modal if the user clicks outside it (not working) :
  // ngAfterViewInit() : void {
  //   document.onclick = (args : any) : void => {
  //     if(args.target.tagName === 'BODY') {
  //       this.modalDialog?.close();
  //     }
  //   }
  // }

  onAddComment() : void {
    this.dialogConfig.id = "addComment";
    this.dialogConfig.data = {
      patientId : this.patientId
    }
    this.modalComment = this.matDialog.open(AddCommentComponent, this.dialogConfig);
  }

  onAssignBed() : void {
    this.router.navigateByUrl("/admission/" + this.patientId);
  }

  onOuting() : void {
    this.dialogConfig.id = "removeBed";
    this.dialogConfig.data = {
      patient : this.patient
    }
    this.modalOuting = this.matDialog.open(RemoveFromBedComponent, this.dialogConfig);
  }
}
