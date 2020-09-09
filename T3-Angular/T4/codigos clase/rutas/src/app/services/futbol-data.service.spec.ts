import { TestBed } from '@angular/core/testing';

import { FutbolDataService } from './futbol-data.service';

describe('FutbolDataService', () => {
  let service: FutbolDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FutbolDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
