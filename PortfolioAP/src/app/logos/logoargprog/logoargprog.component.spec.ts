import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoargprogComponent } from './logoargprog.component';

describe('LogoargprogComponent', () => {
  let component: LogoargprogComponent;
  let fixture: ComponentFixture<LogoargprogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoargprogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogoargprogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
