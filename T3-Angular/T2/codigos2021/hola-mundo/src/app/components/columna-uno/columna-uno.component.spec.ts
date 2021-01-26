import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnaUnoComponent } from './columna-uno.component';

describe('ColumnaUnoComponent', () => {
  let component: ColumnaUnoComponent;
  let fixture: ComponentFixture<ColumnaUnoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColumnaUnoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColumnaUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
