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
import { AddUserComponent } from './components/add-user/add-user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditPatientComponent } from './components/edit-patient/edit-patient.component';
import { AdmissionComponent } from './components/admission/admission.component';
import { RemoveFromBedComponent } from './components/remove-from-bed/remove-from-bed.component';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ConnexionComponent,
    HeaderComponent,
    HeaderDynComponent,
    AddUserComponent,
    AddPatientComponent,
    PatientsListComponent,
    PatientsInComponent,
    PatientsOutComponent,
    PatientDetailComponent,
    AddCommentComponent,
    EditPatientComponent,
    AdmissionComponent,
    RemoveFromBedComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatDialogModule,
    FormsModule,
    MatInputModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
