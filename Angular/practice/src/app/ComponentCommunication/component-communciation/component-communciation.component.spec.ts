import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentCommunciationComponent } from './component-communciation.component';

describe('ComponentCommunciationComponent', () => {
  let component: ComponentCommunciationComponent;
  let fixture: ComponentFixture<ComponentCommunciationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComponentCommunciationComponent]
    });
    fixture = TestBed.createComponent(ComponentCommunciationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
