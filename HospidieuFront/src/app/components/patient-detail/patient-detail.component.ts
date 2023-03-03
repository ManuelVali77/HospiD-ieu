import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Information } from 'src/app/models/information.model';
import { PatientAndBed } from 'src/app/models/patient-and-bed.model';
import { AuthService } from 'src/app/service/auth.service';
import { PatientService } from 'src/app/services/patient.service';
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
  monitoring !: Information[];

  isInfirmier!: boolean;
  isSecretaire!: boolean;

  // Modal component :
  dialogConfig = new MatDialogConfig();
  modalComment : MatDialogRef<AddCommentComponent, any> | undefined;
  modalOuting : MatDialogRef<RemoveFromBedComponent, any> | undefined;

  constructor(private patientService : PatientService, private route : ActivatedRoute, private router : Router, private matDialog : MatDialog, private authService: AuthService) {}

  ngOnInit() : void {
    this.patientId = this.route.snapshot.params['id'];
      this.patientService.getPatientInBedById(this.patientId).subscribe((data : PatientAndBed) => {
        this.patient = data;
      })
      this.patientService.getMonitoringByPatientId(this.patientId).subscribe((data: Information[]) => { this.monitoring = data});

    this.isInfirmier = this.authService.checkInfirmier(sessionStorage.getItem('roles'));
    this.isSecretaire = this.authService.checkSecretaire(sessionStorage.getItem('roles'));
  }

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

  onEditPatient(id : number) : void {
    this.router.navigateByUrl("editPatient/" + id);
    
  }

  onOuting() : void {
    this.dialogConfig.id = "removeBed";
    this.dialogConfig.data = {
      patient : this.patient
    }
    this.modalOuting = this.matDialog.open(RemoveFromBedComponent, this.dialogConfig);
  }
}
