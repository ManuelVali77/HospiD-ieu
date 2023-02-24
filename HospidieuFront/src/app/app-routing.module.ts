import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { ConnexionComponent } from './components/connexion/connexion.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  {path: 'addPatient', component: AddPatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
