import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CiclosComponent } from './ciclos.component';

describe('CiclosComponent', () => {
  let component: CiclosComponent;
  let fixture: ComponentFixture<CiclosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CiclosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CiclosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
