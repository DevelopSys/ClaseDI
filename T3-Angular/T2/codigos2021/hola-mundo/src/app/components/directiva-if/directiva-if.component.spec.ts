import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectivaIfComponent } from './directiva-if.component';

describe('DirectivaIfComponent', () => {
  let component: DirectivaIfComponent;
  let fixture: ComponentFixture<DirectivaIfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DirectivaIfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectivaIfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
