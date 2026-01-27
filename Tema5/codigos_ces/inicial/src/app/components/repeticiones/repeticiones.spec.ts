import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Repeticiones } from './repeticiones';

describe('Repeticiones', () => {
  let component: Repeticiones;
  let fixture: ComponentFixture<Repeticiones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Repeticiones]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Repeticiones);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
