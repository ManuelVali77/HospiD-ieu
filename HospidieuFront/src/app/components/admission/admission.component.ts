import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bed } from 'src/app/models/bed.model';
import { PatientAndBed } from 'src/app/models/patient-and-bed.model';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.scss']
})
export class AdmissionComponent {

  allEmptyBeds !: Bed[];
  idPatient !: number;
  patient !: Patient;
  admitForm !: FormGroup;
  departments !: string[];
  rooms !: number[];
  beds !: number[];
  errorMessage !: string;

  constructor(
    private patientService : PatientService,
    private route : ActivatedRoute,
    private formBuilder : FormBuilder,
    private router : Router
  ) {}

  ngOnInit() : void {
    this.idPatient = this.route.snapshot.params['id'];
    this.patientService.getPatientToAdmit(this.idPatient).subscribe((data : Patient) => {
      this.patient = data;
    });

    this.patientService.getEmptyBeds().subscribe((data : Bed[]) => {
      this.allEmptyBeds = data;
      this.getDepartments();
    });

    this.admitForm = this.formBuilder.group({
      department : ["", Validators.required],
      room : ["", Validators.required],
      bed : ["", Validators.required]
    });

  }

  findBedId() : number {
    let bedId = 0;
    let selectedBed = this.admitForm.value;
    for (let bed of this.allEmptyBeds) {
      if (
        bed.department == selectedBed.department
        && bed.roomNumber == selectedBed.room
        && bed.bedNumber == selectedBed.bed
        ) {
          bedId = bed.idBed;
        }
    }
    return bedId;
  }

  getDepartments() : void {
    this.departments = [];
    for (let bed of this.allEmptyBeds) {
      if (!this.departments.includes(bed.department)) {
        this.departments.push(bed.department);
      }
    }
  }

  onSelectDept(dept : string) : void {
    this.rooms = [];
    for (let bed of this.allEmptyBeds) {
      if(bed.department == dept && !this.rooms.includes(bed.roomNumber)) {
        this.rooms.push(bed.roomNumber);
      }
    }
    this.admitForm.patchValue({room : ''});
    this.admitForm.patchValue({bed : ''});
  }
  
  onSelectRoom(roomInput : string, dept : string) : void {
    const roomNumber = +roomInput;
    this.beds = [];
    for (let bed of this.allEmptyBeds) {
      if(bed.department == dept && bed.roomNumber == roomNumber && !this.beds.includes(bed.bedNumber)) {
        this.beds.push(bed.bedNumber);
      }
    }
    this.admitForm.patchValue({bed : ''});
  }

  onSubmit() : void {
    if (this.admitForm.valid) {
      const patientToAdmit : PatientAndBed = {
        ...this.admitForm.value,
        idPatient : this.idPatient,
        idBed : this.findBedId(),
        userMail : sessionStorage.getItem('mail')
      };

      this.patientService.admitPatient(patientToAdmit).subscribe(() => console.log("Envoyé"));
      this.onCancel();
    } else {
      console.log("Non envoyé");
      this.errorMessage = "Tous les champs sont requis"
    }

  }

  onCancel() : void {
    this.router.navigateByUrl('/patient/' + this.idPatient+"/history");
  }
}
