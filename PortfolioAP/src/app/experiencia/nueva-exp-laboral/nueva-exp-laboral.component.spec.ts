import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaExpLaboralComponent } from './nueva-exp-laboral.component';

describe('NuevaExpLaboralComponent', () => {
  let component: NuevaExpLaboralComponent;
  let fixture: ComponentFixture<NuevaExpLaboralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevaExpLaboralComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevaExpLaboralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
