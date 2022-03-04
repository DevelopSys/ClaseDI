import { TestBed } from '@angular/core/testing';

import { DatosCiclosService } from './datos-ciclos.service';

describe('DatosCiclosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DatosCiclosService = TestBed.get(DatosCiclosService);
    expect(service).toBeTruthy();
  });
});
