import { Injectable } from '@angular/core';
import {ChargeDeCompte} from "../modules/chargedecompte.module";
import {HttpClient} from "@angular/common/http";
import {Ng2Webstorage} from "ngx-webstorage";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ChargedecompteService {
  private baseUrl:string='http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private chargedecompte:ChargeDeCompte;
  private username:String;
  private isUserLoggedIn;

  constructor(private http:HttpClient,private Ws:Ng2Webstorage) {
    this.isUserLoggedIn=false;
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  getChargeDeComptetbyLogin(login)
  {
    return this.http.get(this.baseUrl+'/apicc/cclogin?login='+login).catch(this.errorHandler);
  }
}
