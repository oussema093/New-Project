import { Injectable } from '@angular/core';
import {Http, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";

import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import {observable} from "rxjs/symbol/observable";
import {Consultant} from "../modules/consultant.module";
//import {LocalStorageService, LocalStorage} from 'ng2-webstorage';
import {Ng2Webstorage} from 'ngx-webstorage';
import {LocalStorageService, LocalStorage} from 'ngx-webstorage';




@Injectable()
export class ConsultantService {
  private baseUrl:string='http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private consultant:Consultant;
  constructor(private http:Http,private Ws:Ng2Webstorage) { }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  getConsultants(motCle:String,page:number,size:number){

    return this.http.get(this.baseUrl+'/api/chercherconsultant?mc='+motCle+'&size='+size+'&page='+page).map(resp => resp.json()).catch(this.errorHandler);

  }
  getConsultantByid(id:number){

    return this.http.get(this.baseUrl+'/api/consultant/'+id).map(resp => resp.json()).catch(this.errorHandler);

  }
  deleteConsultant(id:number){

    return this.http.delete(this.baseUrl+'/api/consultant/'+id).map(resp => resp.json()).catch(this.errorHandler);

  }
  createConsultant(consultant:Consultant){

    return this.http.post(this.baseUrl+'/api/consultant/',consultant).map(resp => resp.json()).catch(this.errorHandler);

  }
  updateConsultant(consultant:Consultant){

    return this.http.put(this.baseUrl+'/api/consultant/',consultant).map(resp => resp.json()).catch(this.errorHandler);

  }
  /*loginConsultant(consultant:Consultant)
   {
   return localStorage.getItem(this.http.post(this.baseUrl+'/Security/login/',consultant).map(resp => resp.json()).catch(this.errorHandler));
   }*/
  setter(consultant)
  {
    this.consultant=consultant;
  }
  getter()
  {
    return this.consultant;
  }
}
