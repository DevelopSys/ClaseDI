import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnaDosComponent } from './columna-dos.component';

describe('ColumnaDosComponent', () => {
  let component: ColumnaDosComponent;
  let fixture: ComponentFixture<ColumnaDosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColumnaDosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColumnaDosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
