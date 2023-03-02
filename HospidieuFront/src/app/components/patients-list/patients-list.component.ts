import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.scss']
})
export class PatientsListComponent {

  show !: string;
  searchText!: any;

  constructor(
    private route : ActivatedRoute,
    private router : Router
  ) {}

  ngOnInit() : void {
    this.show = this.route.snapshot.params['param'];
  }


  onShowPatientsIn() : void {
    this.show = 'in';
    this.router.navigateByUrl("patientsList/" + this.show);
  }

  onShowPatientsOut() : void {
    this.show = 'out';
    this.router.navigateByUrl("patientsList/" + this.show);
  }

}
