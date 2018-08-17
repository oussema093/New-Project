import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Consultantform2Component } from './consultantform2.component';

describe('Consultantform2Component', () => {
  let component: Consultantform2Component;
  let fixture: ComponentFixture<Consultantform2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Consultantform2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Consultantform2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
