import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { HeaderComponent } from './components/header/header.component';
import { HeaderDynComponent } from './components/header-dyn/header-dyn.component';
import { PatientsInComponent } from './components/patients-in/patients-in.component';
import { PatientsOutComponent } from './components/patients-out/patients-out.component';
import { PatientDetailComponent } from './components/patient-detail/patient-detail.component';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    HeaderComponent,
    HeaderDynComponent,
    PatientsListComponent,
    PatientsInComponent,
    PatientsOutComponent,
    PatientDetailComponent,
    AddCommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
