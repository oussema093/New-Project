import { TestBed, inject } from '@angular/core/testing';

import { ChargedecompteService } from './chargedecompte.service';

describe('ChargedecompteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChargedecompteService]
    });
  });

  it('should be created', inject([ChargedecompteService], (service: ChargedecompteService) => {
    expect(service).toBeTruthy();
  }));
});
