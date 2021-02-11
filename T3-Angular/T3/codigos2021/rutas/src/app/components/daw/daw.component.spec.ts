import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DawComponent } from './daw.component';

describe('DawComponent', () => {
  let component: DawComponent;
  let fixture: ComponentFixture<DawComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DawComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DawComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
