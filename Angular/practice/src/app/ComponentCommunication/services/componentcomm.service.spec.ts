import { TestBed } from '@angular/core/testing';

import { ComponentcommService } from './componentcomm.service';

describe('ComponentcommService', () => {
  let service: ComponentcommService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComponentcommService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
