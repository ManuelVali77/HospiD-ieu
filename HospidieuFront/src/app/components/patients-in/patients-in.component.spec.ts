import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientsInComponent } from './patients-in.component';

describe('PatientsInComponent', () => {
  let component: PatientsInComponent;
  let fixture: ComponentFixture<PatientsInComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientsInComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientsInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
