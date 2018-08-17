import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {ConsultantService} from "./shared-service/consultant.service";

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private service:ConsultantService,private router:Router)
  {
  }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot):boolean
  {
    if (!this.service.getUserLoggedIn() ) {
      console.log("false");

    this.router.navigate(['/login']);
    }
    if (this.service.getUserLoggedIn())
    {
      console.log("true");



    }
    return this.service.getUserLoggedIn();
  }
}
