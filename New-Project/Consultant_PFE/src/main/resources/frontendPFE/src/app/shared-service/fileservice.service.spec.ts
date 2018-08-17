import { TestBed, inject } from '@angular/core/testing';

import { FileserviceService } from './fileservice.service';

describe('FileserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FileserviceService]
    });
  });

  it('should be created', inject([FileserviceService], (service: FileserviceService) => {
    expect(service).toBeTruthy();
  }));
});
