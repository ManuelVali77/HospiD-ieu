import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header-dyn',
  templateUrl: './header-dyn.component.html',
  styleUrls: ['./header-dyn.component.scss'],
})
export class HeaderDynComponent implements OnInit {
  isAdmin!: boolean;
  isSecretaire!: boolean;
  mailUser!: string | null;
  displayRole!: string;

  constructor(private route: Router, private authService: AuthService) {}

  ngOnInit(): void {
    this.mailUser = sessionStorage.getItem('mail');
    this.isAdmin = this.authService.checkAdmin(sessionStorage.getItem('roles'));
    this.isSecretaire = this.authService.checkSecretaire(sessionStorage.getItem('roles'));
    if (this.isAdmin) {
      this.displayRole = 'Administrateur.trice';
    } else if (this.isSecretaire) {
      this.displayRole = 'Secrétaire';
    } else {
      this.displayRole = 'Infirmier.e';
    }
  }

  goToAddUser() {
    this.route.navigate(['/addUser']);
  }

  onLogout() {
    this.authService.logout();
  }
}
