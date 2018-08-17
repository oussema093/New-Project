import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MissionnonaffecteComponent } from './missionnonaffecte.component';

describe('MissionnonaffecteComponent', () => {
  let component: MissionnonaffecteComponent;
  let fixture: ComponentFixture<MissionnonaffecteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MissionnonaffecteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MissionnonaffecteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
