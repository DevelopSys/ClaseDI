import { TestBed } from '@angular/core/testing';

import { NoticiasService } from './noticias.service';

describe('NoticiasService', () => {
  let service: NoticiasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NoticiasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
