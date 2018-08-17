import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Ng2Webstorage} from "ngx-webstorage";
import {Observable} from "rxjs/Observable";
import {Competences} from "../modules/competences.module";
import {Consultant} from "../modules/consultant.module";
import {Experience} from "../modules/experience.module";
import {Mission} from "../modules/mission.module";
import {JwtHelper} from "angular2-jwt";

@Injectable()
export class AuthenticationService {
  private baseUrl:string = "http://localhost:8080";
  private jwtToken:string=null;
  private roles:Array<any>;
  private competences:Competences;
  private consultant:Consultant;
  private username:String;
  private experience:Experience;
  private mission:Mission;


  constructor(private http:HttpClient,private Ws:Ng2Webstorage) {
  }
  errorHandler(error:Response)
  {
    return Observable.throw(error||"SERVER ERROR");
  }

  login(user){
    return  this.http.post(this.baseUrl+"/login",user,{observe: 'response'});
  }


  saveToken(jwt:string)
  {
    this.jwtToken = jwt;
    localStorage.setItem('token',jwt);
    let jwtHelper=new JwtHelper();
    this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
  }

  loadToken()
  {
    this.jwtToken=localStorage.getItem('token');
  }
  logout()
  {
    this.jwtToken=null;
    localStorage.removeItem('token');
  }
  isConsultant()
  {
    for(let r of this.roles)
    {
      if(r.authority=='CONSULTANT')
        return true;}
    return false;
  }
  isAdmin()
  {
    for(let r of this.roles)
    {
      if(r.authority=='ADMIN')
        return true;}
    return false;

  }
  isClient()
  {
    for(let r of this.roles)
    {
      if(r.authority=='CLIENT')
        return true;}
    return false;
  }
  isCC()
  {
    for(let r of this.roles)
    {
      if(r.authority=='CHARGEDECOMPTE')
        return true;}
    return false;
  }
  isPartenaire()
  {
    for(let r of this.roles)
    {
      if(r.authority=='PARTENAIRE')
        return true;}
    return false;
  }
  isRecruteur()
{
  for(let r of this.roles)
{
  if(r.authority=='RECRUTEUR')
  return true;
}

return false;

}













  getChargeDeComptetbyLogin(login)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/apicc/cclogin?login='+login, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }
  getClientbyLogin(login) {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl + '/apicl/clientlogin?login=' + login, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
    //

  }
  recherchecompsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api2/recherchecompsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }

  deleteCompetences(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.delete(this.baseUrl+'/api2/competences/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  createCompetences(competences:Competences){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.post(this.baseUrl+'/api2/competences/',competences, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  updateCompetences(competences:Competences){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.put(this.baseUrl+'/api2/competences/',competences, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  rechercheCompetences(motCle:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api2/comp?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  rechercheCompetences2(motCle:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api2/comp2?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  valide(motCle:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api2/valide?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  rechercheCompetencesAV(motCle:String,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api2/rechav?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);//
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
  getConsultants(motCle:String,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get(this.baseUrl+'/api/chercherconsultant?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  getConsultantsvalides(motCle:String,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get(this.baseUrl+'/api/valide?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  getConsultantsnonvalide(motCle:String,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api/nonvalide?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }

  getConsultantByid(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api/consultant/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  deleteConsultant(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.delete(this.baseUrl+'/api/consultant/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  createConsultant(consultant:Consultant){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.post(this.baseUrl+'/api/consultant/',consultant, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  updateConsultant(consultant:Consultant){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api/consultant/',consultant, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  loginUser(username:String,password:string)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/user/auth?login='+username+'&pwd='+password, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  /*loginConsultant(consultant:Consultant)
   {
   return localStorage.getItem(this.http.post(this.baseUrl+'/Security/login/',consultant).map(resp => resp.json()).catch(this.errorHandler));
   }*/
  settercons(consultant)
  {
    this.consultant=consultant;

  }
  gettercons()
  {
    return this.consultant;
  }
  setterlogin(login)
  {
    this.username=login;

  }
  getterlogin()
  {
    return this.username;
  }
  getUserbyLogin(login)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api/consultantlogin?login='+login, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }

  activerConsultant(id:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api/consultant/activer/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }
  desactiverConsultant(id:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api/consultant/desactiver/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }
  valider(id:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api/consultant/valider/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }
  nonvalider(id:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api/consultant/nonvalider/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }
  recommander(comp:Competences)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    console.log(comp.consultant.email);
    return this.http.get(this.baseUrl+'/api99/recommander/'+'?to='+comp.consultant.email+'&x=recommandation consultant PFE'+'&msg='+'vous etes recommandé monsieur_'+comp.consultant.nom+'_'+comp.consultant.prenom, {headers: new HttpHeaders({'Authorization':this.jwtToken})});
  }
  recruter(comp:Competences)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    console.log(comp.consultant.email);
    return this.http.get(this.baseUrl+'/api99/recommander/'+'?to='+comp.consultant.email+'&x=recrutement consultant PFE'+'&msg='+'vous etes recruté monsieur_'+comp.consultant.nom+'_'+comp.consultant.prenom, {headers: new HttpHeaders({'Authorization':this.jwtToken})});
  }
  affecter(mission:Mission,consultant:Consultant)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    if(mission.client!=null)
    {
      console.log("client non null")
      console.log("email "+mission.client.email);
      console.log("consultant est "+consultant.userName);
      return this.http.get(this.baseUrl+'/api99/recommander/'+'?to='+mission.client.email+'&x=Affectation Mission'+'&msg='+'votre mission est affecté à _'+consultant.nom+'_'+consultant.prenom, {headers: new HttpHeaders({'Authorization':this.jwtToken})});

    }
    if(mission.chargedecompte!=null)
    {
      if (this.jwtToken==null)
      {this.loadToken()};
      return this.http.get(this.baseUrl+'/api99/recommander/'+'?to='+mission.chargedecompte.email+'&x=Affectation Mission'+'&msg='+'votre mission est affecté à _'+consultant.nom+'_'+consultant.prenom, {headers: new HttpHeaders({'Authorization':this.jwtToken})});


    }
  }
  rechercheexpsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/api3/rechercheexpsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }

  deleteExperience(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.delete(this.baseUrl+'/api3/experiences/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  createExperience(experience:Experience){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.post(this.baseUrl+'/api3/experiences/',experience, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  updateExperience(experience:Experience){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/api3/experiences/',experience,{headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

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
  create(file:File){
    if (this.jwtToken==null)
    {this.loadToken()};
    const _formData = new FormData();
    _formData.append('file', file, file.name);
    // return this.http.post(UrlFileUpload, _formData);

    return this.http.post(this.baseUrl+'/uploadFile/',_formData, {headers: new HttpHeaders({'Authorization':this.jwtToken})});

  }
  download(url)
  {
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get("http://localhost:8080/downloadFile/16");
  }

  getMissions(motCle:String,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get(this.baseUrl+'/apimission/cherchermission?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  getMissionsByConsultant(motCle:number,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get(this.baseUrl+'/apimission/getmissionsbyconsultant?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  getMissionsBynonaffecte(motCle:String,page:number,size:number){
    if (this.jwtToken==null)
    {this.loadToken()};

    return this.http.get(this.baseUrl+'/apimission/recherchemissionnonaffecte?mc='+motCle+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }


  recherchemissionsbyconsultant(motCle:number,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbyconsultant?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  recherchemissionsbyclient(motCle:number,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbyclient?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  recherchemissionsbychargedecompte(motCle:number,motCle2:String,page:number,size:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/apimission/recherchemissionsbycc?mc='+motCle+'&mc2='+motCle2+'&size='+size+'&page='+page, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  getMissionByid(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.get(this.baseUrl+'/apimission/mission/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  deleteMission(id:number){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.delete(this.baseUrl+'/apimission/mission/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  createMission(mission:Mission){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.post(this.baseUrl+'/apimission/mission/',mission, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  updateMission(mission:Mission){
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/apimission/mission/',mission, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

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
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/apimission/mission/desactiver/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  activerMission(id:number)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/apimission/mission/activer/'+id, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  supprimerMissionAuto()
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.delete(this.baseUrl+'/apimission/missionauto/', {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);

  }
  saffecter(mission:Mission)
  {
    if (this.jwtToken==null)
    {this.loadToken()};
    return this.http.put(this.baseUrl+'/apimission/affectermission',mission, {headers: new HttpHeaders({'Authorization':this.jwtToken})}).catch(this.errorHandler);
  }

//
}
