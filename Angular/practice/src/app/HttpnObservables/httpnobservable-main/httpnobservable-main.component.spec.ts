import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpnobservableMainComponent } from './httpnobservable-main.component';

describe('HttpnobservableMainComponent', () => {
  let component: HttpnobservableMainComponent;
  let fixture: ComponentFixture<HttpnobservableMainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HttpnobservableMainComponent]
    });
    fixture = TestBed.createComponent(HttpnobservableMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
