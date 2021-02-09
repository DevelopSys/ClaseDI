import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TituloComponent } from './titulo.component';

describe('TituloComponent', () => {
  let component: TituloComponent;
  let fixture: ComponentFixture<TituloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TituloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TituloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
