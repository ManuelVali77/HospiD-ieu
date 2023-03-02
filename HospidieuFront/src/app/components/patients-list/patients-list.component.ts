import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.scss']
})
export class PatientsListComponent {

  show !: string;

  constructor(
    private route : ActivatedRoute
  ) {}

  ngOnInit() : void {
    this.show = this.route.snapshot.params['param'];
  }


  onShowPatientsIn() : void {
    this.show = 'in';
  }

  onShowPatientsOut() : void {
    this.show = 'out';
  }

}
