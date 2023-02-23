import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  { path : "patientsList", component : PatientsListComponent },
  { path : "patientsList/in", component : PatientsInComponent },
  { path : "patientsList/out", component : PatientsOutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
