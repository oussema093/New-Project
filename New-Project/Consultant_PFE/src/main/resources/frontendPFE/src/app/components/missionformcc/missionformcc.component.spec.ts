import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionformccComponent } from './missionformcc.component';

describe('MissionformccComponent', () => {
  let component: MissionformccComponent;
  let fixture: ComponentFixture<MissionformccComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionformccComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionformccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
