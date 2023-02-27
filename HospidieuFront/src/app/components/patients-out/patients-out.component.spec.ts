import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientsOutComponent } from './patients-out.component';

describe('PatientsOutComponent', () => {
  let component: PatientsOutComponent;
  let fixture: ComponentFixture<PatientsOutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientsOutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatientsOutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
