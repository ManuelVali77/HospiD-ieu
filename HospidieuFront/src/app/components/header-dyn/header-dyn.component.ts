import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-dyn',
  templateUrl: './header-dyn.component.html',
  styleUrls: ['./header-dyn.component.scss'],
})
export class HeaderDynComponent {
  constructor(private route: Router) {}

}
