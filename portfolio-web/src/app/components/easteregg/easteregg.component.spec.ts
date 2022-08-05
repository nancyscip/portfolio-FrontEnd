import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EastereggComponent } from './easteregg.component';

describe('EastereggComponent', () => {
  let component: EastereggComponent;
  let fixture: ComponentFixture<EastereggComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EastereggComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EastereggComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
