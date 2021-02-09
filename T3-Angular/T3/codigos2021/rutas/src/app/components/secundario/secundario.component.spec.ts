import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecundarioComponent } from './secundario.component';

describe('SecundarioComponent', () => {
  let component: SecundarioComponent;
  let fixture: ComponentFixture<SecundarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecundarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecundarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
