import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Seperate1Component } from './seperate1.component';

describe('Seperate1Component', () => {
  let component: Seperate1Component;
  let fixture: ComponentFixture<Seperate1Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Seperate1Component]
    });
    fixture = TestBed.createComponent(Seperate1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
