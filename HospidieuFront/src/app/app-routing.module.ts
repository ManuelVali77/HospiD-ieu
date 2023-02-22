import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AddUserComponent } from './components/add-user/add-user.component';

const routes: Routes = [
  {path: 'login', component: ConnexionComponent},
  {path: 'addUser', component: AddUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
