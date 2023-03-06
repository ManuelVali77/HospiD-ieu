import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDto } from '../models/userDto.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  authenticated = false;
  private baseUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  addUser(userDto: UserDto): Observable<Object>{
    return this.http.post<UserDto>(this.baseUrl +"addUser", userDto);
  }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}user`);
  }
}