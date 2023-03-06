import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/models/role.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  users!: User[];
  roles!: Role[];
  title = 'Angular Search Using ng2-search-filter';
  searchText!: any;
  
  constructor(private userService: UserService) {

   }

  ngOnInit(): void {
    
    this.userService.getUsers().subscribe((data: User[]) => {
      console.log(data);
      this.users = data;
      
    });
  }
  

  
}