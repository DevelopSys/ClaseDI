import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignaturaComponent } from './asignatura.component';

describe('AsignaturaComponent', () => {
  let component: AsignaturaComponent;
  let fixture: ComponentFixture<AsignaturaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsignaturaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsignaturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
