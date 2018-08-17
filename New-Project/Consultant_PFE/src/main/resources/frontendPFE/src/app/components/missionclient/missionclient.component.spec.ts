import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionclientComponent } from './missionclient.component';

describe('MissionclientComponent', () => {
  let component: MissionclientComponent;
  let fixture: ComponentFixture<MissionclientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionclientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
