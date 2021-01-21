import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteInicialComponent } from './componente-inicial.component';

describe('ComponenteInicialComponent', () => {
  let component: ComponenteInicialComponent;
  let fixture: ComponentFixture<ComponenteInicialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteInicialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteInicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
