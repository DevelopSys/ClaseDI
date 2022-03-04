import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectivaSwitchComponent } from './directiva-switch.component';

describe('DirectivaSwitchComponent', () => {
  let component: DirectivaSwitchComponent;
  let fixture: ComponentFixture<DirectivaSwitchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DirectivaSwitchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectivaSwitchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
