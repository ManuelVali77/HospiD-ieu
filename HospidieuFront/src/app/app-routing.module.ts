import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { UserComponent } from './components/user/user.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  {path: 'addPatient', component: AddPatientComponent},
  { path: 'user', component: UserComponent },
  { path : "patientsList", component : PatientsListComponent },
  { path : "patientsList/in", component : PatientsInComponent },
  { path : "patientsList/out", component : PatientsOutComponent },
  { path : "patient/:id", component : PatientDetailComponent },
  { path : "comment/:id", component : AddCommentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
