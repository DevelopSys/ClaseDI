import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Decisiones } from './decisiones';

describe('Decisiones', () => {
  let component: Decisiones;
  let fixture: ComponentFixture<Decisiones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Decisiones]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Decisiones);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
