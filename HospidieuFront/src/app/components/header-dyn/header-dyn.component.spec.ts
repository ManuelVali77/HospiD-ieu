import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HeaderDynComponent } from './header-dyn.component';

describe('HeaderDynComponent', () => {
  let component: HeaderDynComponent;
  let fixture: ComponentFixture<HeaderDynComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderDynComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderDynComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
