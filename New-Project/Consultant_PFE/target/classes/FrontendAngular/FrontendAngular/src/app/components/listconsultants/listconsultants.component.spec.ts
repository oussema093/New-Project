import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListconsultantsComponent } from './listconsultants.component';

describe('ListconsultantsComponent', () => {
  let component: ListconsultantsComponent;
  let fixture: ComponentFixture<ListconsultantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListconsultantsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListconsultantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
