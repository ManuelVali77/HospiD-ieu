import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { UserComponent } from './components/user/user.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';
import { EditPatientComponent } from './components/edit-patient/edit-patient.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  {path: 'addUser', component: AddUserComponent},
  {path: 'addPatient', component: AddPatientComponent},
  { path: 'user', component: UserComponent },
  { path : "patientsList", component : PatientsListComponent },
  { path : "patientsList/in", component : PatientsInComponent },
  { path : "patientsList/out", component : PatientsOutComponent },
  { path : "patient/:id", component : PatientDetailComponent },
  { path : "editPatient/:id", component : EditPatientComponent },
  

  // Redirections :
  { path : "", redirectTo : '/login', pathMatch : 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
