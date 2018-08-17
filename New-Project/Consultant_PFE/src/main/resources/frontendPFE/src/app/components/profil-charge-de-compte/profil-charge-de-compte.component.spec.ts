import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilChargeDeCompteComponent } from './profil-charge-de-compte.component';

describe('ProfilChargeDeCompteComponent', () => {
  let component: ProfilChargeDeCompteComponent;
  let fixture: ComponentFixture<ProfilChargeDeCompteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilChargeDeCompteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilChargeDeCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
