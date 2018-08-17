import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetencesformComponent } from './competencesform.component';

describe('CompetencesformComponent', () => {
  let component: CompetencesformComponent;
  let fixture: ComponentFixture<CompetencesformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompetencesformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompetencesformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
