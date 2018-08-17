import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NonvalideComponent } from './nonvalide.component';

describe('NonvalideComponent', () => {
  let component: NonvalideComponent;
  let fixture: ComponentFixture<NonvalideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NonvalideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NonvalideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
