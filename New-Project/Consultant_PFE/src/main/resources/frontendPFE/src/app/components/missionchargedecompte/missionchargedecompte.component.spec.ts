import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionchargedecompteComponent } from './missionchargedecompte.component';

describe('MissionchargedecompteComponent', () => {
  let component: MissionchargedecompteComponent;
  let fixture: ComponentFixture<MissionchargedecompteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionchargedecompteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionchargedecompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
