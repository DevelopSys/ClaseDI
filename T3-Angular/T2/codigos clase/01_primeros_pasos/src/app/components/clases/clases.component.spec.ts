import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClasesComponent } from './clases.component';

describe('ClasesComponent', () => {
  let component: ClasesComponent;
  let fixture: ComponentFixture<ClasesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClasesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClasesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
