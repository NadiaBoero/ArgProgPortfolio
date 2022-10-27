import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarExplaboralComponent } from './editar-explaboral.component';

describe('EditarExplaboralComponent', () => {
  let component: EditarExplaboralComponent;
  let fixture: ComponentFixture<EditarExplaboralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarExplaboralComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarExplaboralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
