import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { UserComponent } from './components/user/user.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { EditPatientComponent } from './components/edit-patient/edit-patient.component';
import { AdmissionComponent } from './components/admission/admission.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  {path: 'addUser', component: AddUserComponent},
  {path: 'addPatient', component: AddPatientComponent},
  {path: 'editPatient', component: AddPatientComponent},
  { path: 'user', component: UserComponent },
  { path : "patientsList", component : PatientsListComponent },
  { path : "patientsList/:param", component : PatientsListComponent },
  { path : "patient/:id/history", component : PatientDetailComponent },
  { path : "editPatient/:id", component : EditPatientComponent },
  { path : "admission/:id", component : AdmissionComponent },

  // Redirections :
  { path : "", redirectTo : '/login', pathMatch : 'full' },

  //Page 404 :
  { path: '**', pathMatch: 'full',  component: PagenotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
