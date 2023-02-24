import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AppComponent } from './app.component';
import { UserComponent } from './components/user/user.component';

const routes: Routes = [

  {path: 'login', component: ConnexionComponent},
  
  { path: 'user', component: UserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
