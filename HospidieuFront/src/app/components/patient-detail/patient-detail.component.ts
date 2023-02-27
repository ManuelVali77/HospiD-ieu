import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { AddCommentComponent } from '../add-comment/add-comment.component';

@Component({
  selector: 'app-patient-detail',
  templateUrl: './patient-detail.component.html',
  styleUrls: ['./patient-detail.component.scss']
})
export class PatientDetailComponent implements OnInit {

  @Input() patient !: Patient;
  patientId !: number;

  // Modal component :
  dialogConfig = new MatDialogConfig();
  modalDialog : MatDialogRef<AddCommentComponent, any> | undefined;

  constructor(private route : ActivatedRoute, private router : Router, private matDialog : MatDialog) {}

  ngOnInit() : void {
    this.patientId = this.route.snapshot.params['id'];
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
    this.dialogConfig.id = "modal";
    this.dialogConfig.data = {
      patientId : this.patientId
    }
    this.modalDialog = this.matDialog.open(AddCommentComponent, this.dialogConfig);
  }

}
