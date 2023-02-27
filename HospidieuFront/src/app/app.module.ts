import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './components/user/user.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { HeaderComponent } from './components/header/header.component';
import { HeaderDynComponent } from './components/header-dyn/header-dyn.component';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ConnexionComponent,
    HeaderComponent,
    HeaderDynComponent,
    AddPatientComponent,
    PatientsListComponent,
    PatientsInComponent,
    PatientsOutComponent,
    PatientDetailComponent,
    AddCommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatDialogModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
