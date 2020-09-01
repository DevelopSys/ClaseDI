import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PipesCompComponent } from './pipes-comp.component';

describe('PipesCompComponent', () => {
  let component: PipesCompComponent;
  let fixture: ComponentFixture<PipesCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PipesCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PipesCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
