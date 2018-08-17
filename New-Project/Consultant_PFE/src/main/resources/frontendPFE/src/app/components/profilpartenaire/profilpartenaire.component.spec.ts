import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilpartenaireComponent } from './profilpartenaire.component';

describe('ProfilpartenaireComponent', () => {
  let component: ProfilpartenaireComponent;
  let fixture: ComponentFixture<ProfilpartenaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilpartenaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilpartenaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
