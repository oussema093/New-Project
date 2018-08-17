import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilrecruteurComponent } from './profilrecruteur.component';

describe('ProfilrecruteurComponent', () => {
  let component: ProfilrecruteurComponent;
  let fixture: ComponentFixture<ProfilrecruteurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilrecruteurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilrecruteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
