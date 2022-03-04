import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnaTresComponent } from './columna-tres.component';

describe('ColumnaTresComponent', () => {
  let component: ColumnaTresComponent;
  let fixture: ComponentFixture<ColumnaTresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColumnaTresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColumnaTresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
