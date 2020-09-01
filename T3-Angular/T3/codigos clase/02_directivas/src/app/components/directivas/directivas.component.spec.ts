import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectivasComponent } from './directivas.component';

describe('DirectivasComponent', () => {
  let component: DirectivasComponent;
  let fixture: ComponentFixture<DirectivasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectivasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectivasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
