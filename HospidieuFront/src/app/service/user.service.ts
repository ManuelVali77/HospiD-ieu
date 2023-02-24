import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDto } from '../models/userDto.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080/addUser";

  constructor(private http: HttpClient) { }

  addUser(userDto: UserDto): Observable<Object>{
    return this.http.post<UserDto>(this.baseUrl, userDto);
  }
}