import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Seperate2Component } from './seperate2.component';

describe('Seperate2Component', () => {
  let component: Seperate2Component;
  let fixture: ComponentFixture<Seperate2Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Seperate2Component]
    });
    fixture = TestBed.createComponent(Seperate2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
