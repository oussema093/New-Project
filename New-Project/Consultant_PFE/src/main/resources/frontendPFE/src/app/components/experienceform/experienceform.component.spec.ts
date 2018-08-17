import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperienceformComponent } from './experienceform.component';

describe('ExperienceformComponent', () => {
  let component: ExperienceformComponent;
  let fixture: ComponentFixture<ExperienceformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperienceformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperienceformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
