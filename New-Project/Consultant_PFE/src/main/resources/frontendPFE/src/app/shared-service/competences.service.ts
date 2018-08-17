import { Injectable } from '@angular/core';
import {Competences} from "../modules/competences.module";
import {Ng2Webstorage} from "ngx-webstorage";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CompetencesService {
  private baseUrl:string='http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private competences:Competences;
  private username:String;
  constructor(private http:HttpClient,private Ws:Ng2Webstorage) {
    //
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }


  recherchecompsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api2/recherchecompsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);

  }

  deleteCompetences(id:number){

    return this.http.delete(this.baseUrl+'/api2/competences/'+id).catch(this.errorHandler);

  }
  createCompetences(competences:Competences){

    return this.http.post(this.baseUrl+'/api2/competences/',competences).catch(this.errorHandler);

  }
  updateCompetences(competences:Competences){

    return this.http.put(this.baseUrl+'/api2/competences/',competences).catch(this.errorHandler);

  }
  rechercheCompetences(motCle:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api2/comp?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  rechercheCompetences2(motCle:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api2/comp2?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  valide(motCle:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api2/valide?mc='+motCle+'&size='+size+'&page='+page).catch(this.errorHandler);

  }
  rechercheCompetencesAV(motCle:String,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api2/rechav?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);//
//
  }
  settercomp(comp)
  {
    this.competences=comp;
  }
  gettercomp()
  {
    return this.competences;
  }
}
