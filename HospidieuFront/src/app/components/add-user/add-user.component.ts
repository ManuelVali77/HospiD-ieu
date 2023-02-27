import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserDto } from 'src/app/models/userDto.model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss'],
})
export class AddUserComponent implements OnInit {
  user: UserDto = new UserDto();
  userForm!: FormGroup;
  constructor(
    private userService: UserService,
    private route: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      name: [null, Validators.required],
      firstName: [null, Validators.required],
      mail: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.minLength(10)]],
      role: [null, Validators.required],
    });
  }

  onSubmit() {
    if (this.userForm.dirty && this.userForm.valid) {
      this.user = this.userForm.value;
      this.saveUser();
    } else {
      this.userForm.markAllAsTouched();
    }
  }

  saveUser() {
    this.userService.addUser(this.user).subscribe((data) => {
      alert(`Ajout de l'utilisateur: ${this.userForm.value.name}`);
      this.userForm.reset();
    });
  }
}
