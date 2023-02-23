import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  { path : "patientsList", component : PatientsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
