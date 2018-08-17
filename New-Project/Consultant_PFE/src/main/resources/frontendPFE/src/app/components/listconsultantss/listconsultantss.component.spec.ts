import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListconsultantssComponent } from './listconsultantss.component';

describe('ListconsultantssComponent', () => {
  let component: ListconsultantssComponent;
  let fixture: ComponentFixture<ListconsultantssComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListconsultantssComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListconsultantssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
