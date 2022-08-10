import { TestBed } from '@angular/core/testing';

import { HardysoftService } from './hardysoft.service';

describe('HardysoftService', () => {
  let service: HardysoftService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HardysoftService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
