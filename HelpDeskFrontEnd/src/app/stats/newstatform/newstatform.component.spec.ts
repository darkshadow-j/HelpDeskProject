import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewstatformComponent } from './newstatform.component';

describe('NewstatformComponent', () => {
  let component: NewstatformComponent;
  let fixture: ComponentFixture<NewstatformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewstatformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewstatformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
