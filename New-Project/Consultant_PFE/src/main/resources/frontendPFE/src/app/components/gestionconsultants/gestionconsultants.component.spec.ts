import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionconsultantsComponent } from './gestionconsultants.component';

describe('GestionconsultantsComponent', () => {
  let component: GestionconsultantsComponent;
  let fixture: ComponentFixture<GestionconsultantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionconsultantsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionconsultantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
