import { Injectable } from '@angular/core';
import {Client} from "../modules/client.module";
import {HttpClient} from "@angular/common/http";
import {Ng2Webstorage} from "ngx-webstorage";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ClientService {
  private baseUrl: string = 'http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private client: Client;
  private username: String;
  private isUserLoggedIn;

  constructor(private http: HttpClient, private Ws: Ng2Webstorage) {
    this.isUserLoggedIn = false;
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
  }

  getClientbyLogin(login) {
    return this.http.get(this.baseUrl + '/apicl/clientlogin?login=' + login).catch(this.errorHandler);
    //

  }
}
