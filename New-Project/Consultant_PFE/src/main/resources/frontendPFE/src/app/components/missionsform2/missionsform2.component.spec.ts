import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Missionsform2Component } from './missionsform2.component';

describe('Missionsform2Component', () => {
  let component: Missionsform2Component;
  let fixture: ComponentFixture<Missionsform2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Missionsform2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Missionsform2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
