import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, map, throwError } from 'rxjs';
import { User } from '../models/user.model';

const headers = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Accept', 'application/json');
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/';
  user: User = <User>{};

  constructor(private http: HttpClient, private route: Router) {}

  login(mail: string, password: string) {
    // console.log('In AuthService -  login');
    this.user.mail = mail;
    this.user.password = password;
    return this.http
      .put<User>(this.baseUrl + 'login', this.user, { headers })
      .pipe(
        catchError(this.handleError),
        map((userData) => {
          sessionStorage.setItem('mail', mail);
          let tokenStr = 'Bearer ' + userData.token;
          console.log('Token---  ' + tokenStr);
          sessionStorage.setItem('token', tokenStr);
          sessionStorage.setItem('roles', JSON.stringify(userData.roles));
          return userData;
        })
      );
  }

  logout() {
    console.log(sessionStorage.getItem('mail'));
    console.log(sessionStorage.getItem('roles'));
    sessionStorage.clear();
    this.route.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return sessionStorage.getItem('mail') !== null;
  }

  private handleError(httpError: HttpErrorResponse) {
    let message: string = '';

    if (httpError.error instanceof ProgressEvent) {
      console.log('in progrss event');
      message = 'Network error';
    } else {
      message = httpError.error.message;
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${httpError.status}, ` +
          `body was: ${httpError.error}`
      );
    }
    // Return an observable with a user-facing error message.
    return throwError(message);
  }

  checkAdmin(rolesStr: any): boolean {
    let roles = JSON.parse(rolesStr);
    for (let i = 0; i < roles.length; i++) {
      if (roles[i] === 'ROLE_ADMIN') {
        return true;
      }
    }
    return false;
  }

  checkSecretaire(rolesStr: any): boolean {
    let roles = JSON.parse(rolesStr);
    for (let i = 0; i < roles.length; i++) {
      if (roles[i] === 'ROLE_SECRETAIRE') {
        return true;
      }
    }
    return false;
  }

  checkInfirmier(rolesStr: any): boolean {
    let roles = JSON.parse(rolesStr);
    for (let i = 0; i < roles.length; i++) {
      if (roles[i] === 'ROLE_INFIRMIER') {
        return true;
      }
    }
    return false;
  }
}
