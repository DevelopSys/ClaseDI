import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsirComponent } from './asir.component';

describe('AsirComponent', () => {
  let component: AsirComponent;
  let fixture: ComponentFixture<AsirComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsirComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
