import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveFromBedComponent } from './remove-from-bed.component';

describe('RemoveFromBedComponent', () => {
  let component: RemoveFromBedComponent;
  let fixture: ComponentFixture<RemoveFromBedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemoveFromBedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RemoveFromBedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
