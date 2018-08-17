//MissionService

import { Injectable } from '@angular/core';
import {Http, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";

import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import {observable} from "rxjs/symbol/observable";
//import {LocalStorageService, LocalStorage} from 'ng2-webstorage';
//map(resp => resp.json())
import {Ng2Webstorage} from 'ngx-webstorage';
import {LocalStorageService, LocalStorage} from 'ngx-webstorage';
import {Mission} from "../modules/mission.module";
import {HttpClient} from "@angular/common/http";
@Injectable()
export class MissionService {
  private baseUrl:string='http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private mission:Mission;
  private username:String;
  constructor(private http:HttpClient,private Ws:Ng2Webstorage) { }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }
  getMissions(motCle:String,page:number,size:number){

    return this.http.get(this.baseUrl+'/apimission/cherchermission?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  getMissionsByConsultant(motCle:number,page:number,size:number){

    return this.http.get(this.baseUrl+'/apimission/getmissionsbyconsultant?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  getMissionsBynonaffecte(motCle:String,page:number,size:number){

    return this.http.get(this.baseUrl+'/apimission/recherchemissionnonaffecte?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }


  recherchemissionsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  recherchemissionsbyclient(motCle:number,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbyclient?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  recherchemissionsbychargedecompte(motCle:number,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbycc?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  getMissionByid(id:number){

    return this.http.get(this.baseUrl+'/apimission/mission/'+id).catch(this.errorHandler);

  }
  deleteMission(id:number){

    return this.http.delete(this.baseUrl+'/apimission/mission/'+id).catch(this.errorHandler);

  }
  createMission(mission:Mission){

    return this.http.post(this.baseUrl+'/apimission/mission/',mission).catch(this.errorHandler);

  }
  updateMission(mission:Mission){

    return this.http.put(this.baseUrl+'/apimission/mission/',mission).catch(this.errorHandler);

  }
  settermission(mission)
  {
    this.mission=mission;
  }
  gettermission()
  {
    return this.mission;
  }
  desactiverMission(id:number)
  {
    return this.http.put(this.baseUrl+'/apimission/mission/desactiver/'+id,null).catch(this.errorHandler);

  }
  activerMission(id:number)
  {
    return this.http.put(this.baseUrl+'/apimission/mission/activer/'+id,null).catch(this.errorHandler);

  }
  supprimerMissionAuto()
  {
    return this.http.delete(this.baseUrl+'/apimission/missionauto/').catch(this.errorHandler);

  }
  saffecter(mission:Mission)
  {
    return this.http.put(this.baseUrl+'/apimission/affectermission',mission).catch(this.errorHandler);
  }

}
