import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss'],
})
export class ConnexionComponent implements OnInit {
  user: User = new User();
  loginForm!: FormGroup;

  constructor(
    private authService: AuthService,
    private route: Router,
    private http: HttpClient,
    private formBuilder: FormBuilder
  ) {}

  submitted = false;
  errorMessage = '';
  isLoggedin = false;
  isLoginFailed = false;

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      mail: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
    });
  }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
  }
    this.authService
      .login(this.loginForm.value.mail, this.loginForm.value.password)
      .subscribe(
        (data) => {
          this.isLoggedin = true;
          this.route.navigate(['/patientsList/in']);
        },
        (error) => {
          console.log(error);
          this.errorMessage = error;
          this.isLoggedin = false;
          this.isLoginFailed = true;
        }
      );
  }
}
