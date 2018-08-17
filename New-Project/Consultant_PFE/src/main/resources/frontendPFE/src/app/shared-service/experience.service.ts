import { Injectable } from '@angular/core';
import {Experience} from "../modules/experience.module";
import {Ng2Webstorage} from "ngx-webstorage";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ExperienceService {
  private baseUrl:string='http://localhost:8080';
  //private headers=new Headers({'Content-Type':'application/json'});
  // private options=new RequestOptions({headers:this.headers});
  private experience:Experience;
  private username:String;
  constructor(private http:HttpClient,private Ws:Ng2Webstorage) { }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }


  rechercheexpsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    return this.http.get(this.baseUrl+'/api3/rechercheexpsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page).catch(this.errorHandler);

  }

  deleteExperience(id:number){

    return this.http.delete(this.baseUrl+'/api3/experiences/'+id).catch(this.errorHandler);

  }
  createExperience(experience:Experience){

    return this.http.post(this.baseUrl+'/api3/experiences/',experience).catch(this.errorHandler);

  }
  updateExperience(experience:Experience){

    return this.http.put(this.baseUrl+'/api3/experiences/',experience).catch(this.errorHandler);

  }
  setterexp(exp)
  {
    this.experience=exp;
    console.log('oussema+++++ experience est '+this.experience);
  }
  getterexp()
  {
    return this.experience;
  }

}
