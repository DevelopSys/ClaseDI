import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaComponent } from './materia.component';

describe('MateriaComponent', () => {
  let component: MateriaComponent;
  let fixture: ComponentFixture<MateriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MateriaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MateriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
