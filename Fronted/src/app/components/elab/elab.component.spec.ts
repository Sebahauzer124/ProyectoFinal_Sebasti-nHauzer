import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElabComponent } from './elab.component';

describe('ElabComponent', () => {
  let component: ElabComponent;
  let fixture: ComponentFixture<ElabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
