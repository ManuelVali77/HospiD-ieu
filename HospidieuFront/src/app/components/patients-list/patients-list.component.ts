import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.scss']
})
export class PatientsListComponent {

  show : string = 'in';

  onShowPatientsIn() : void {
    this.show = 'in';
  }

  onShowPatientsOut() : void {
    this.show = 'out';
  }

}
