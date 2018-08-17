import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ListconsultantsComponent } from './components/listconsultants/listconsultants.component';
import { ConsultantformComponent } from './components/consultantform/consultantform.component';
import {RouterModule, Routes} from "@angular/router";
import { ConsultantService} from './shared-service/consultant.service';
import {MissionService} from './shared-service/mission.service';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {Ng2Webstorage} from 'ngx-webstorage';
import { AccueilComponent } from './components/accueil/accueil.component';
import { LoginformComponent } from './components/loginform/loginform.component';
import { ProfiladminComponent } from './components/profiladmin/profiladmin.component';
import { GestionconsultantsComponent } from './components/gestionconsultants/gestionconsultants.component';
import { ProfilconsultantComponent } from './components/profilconsultant/profilconsultant.component';
import { MissionformComponent } from './components/missionform/missionform.component';
import {AuthGuard} from "./auth.guard";
import { UserComponent } from './components/user/user.component';
import { ErreurComponent } from './components/erreur/erreur.component';
import {HttpClientModule} from "@angular/common/http";
import { CompetencesComponent } from './components/competences/competences.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { ExperienceformComponent } from './components/experienceform/experienceform.component';
import { CompetencesformComponent } from './components/competencesform/competencesform.component';
import {CompetencesService} from "./shared-service/competences.service";
import {ExperienceService} from "./shared-service/experience.service";
import { ProfilclientComponent } from './components/profilclient/profilclient.component';
import { ProfilChargeDeCompteComponent } from './components/profil-charge-de-compte/profil-charge-de-compte.component';
import { Consultantform2Component } from './components/consultantform2/consultantform2.component';
import { MissionsComponent } from './components/missions/missions.component';
import { Missionsform2Component } from './components/missionsform2/missionsform2.component';
import { ProfilpartenaireComponent } from './components/profilpartenaire/profilpartenaire.component';
import { ListconsultantssComponent } from './components/listconsultantss/listconsultantss.component';
import { ProfilrecruteurComponent } from './components/profilrecruteur/profilrecruteur.component';
import {FileserviceService} from "./shared-service/fileservice.service";
import { MissionclientComponent } from './components/missionclient/missionclient.component';
import {ClientService} from "./shared-service/client.service";
import {ChargedecompteService} from "./shared-service/chargedecompte.service";
import { MissionformclientComponent } from './components/missionformclient/missionformclient.component';
import { MissionchargedecompteComponent } from './components/missionchargedecompte/missionchargedecompte.component';
import { MissionformccComponent } from './components/missionformcc/missionformcc.component';
import { MissionnonaffecteComponent } from './components/missionnonaffecte/missionnonaffecte.component';
import { NonvalideComponent } from './components/nonvalide/nonvalide.component';
import {AuthenticationService} from "./shared-service/authentication.service";
import { LoginComponent } from './components/login/login.component';


const appRoutes:Routes=[
  {path:'op/:name',component:ConsultantformComponent},
  {path:'list/:name',component:ListconsultantsComponent},
  {path:'accueil',component:AccueilComponent},
  {path:'login',component:LoginformComponent},
  {path:'admin/:name',component:ProfiladminComponent},//,canActivate:[AuthGuard]
  {path:'consultant/:name',component:ProfilconsultantComponent},//,canActivate:[AuthGuard]
  {path:'gc',component:GestionconsultantsComponent},
  {path:'gestionmission/:name',component:MissionformComponent},
  {path:'404',component:ErreurComponent},
  {path:'users/:name',component:UserComponent},
  {path:'competences/:name',component:CompetencesComponent},
  {path:'experiences/:name',component:ExperienceComponent},
  {path:'competencesform/:name',component:CompetencesformComponent},
  {path:'experiencesform/:name',component:ExperienceformComponent},
  {path:'client/:name',component:ProfilclientComponent},
  {path:'chargeCompte/:name',component:ProfilChargeDeCompteComponent},
  {path:'op2/:name',component:Consultantform2Component},
  {path:'missions/:name',component:MissionsComponent},
  {path:'gestionmission2/:name',component:Missionsform2Component},
  {path:'partenaire/:name',component:ProfilpartenaireComponent},
  {path:'consultantss/:name',component:ListconsultantssComponent},
  {path:'recruteur/:name',component:ProfilrecruteurComponent},
  {path:'mc/:name',component:MissionclientComponent},

  {path:'gestionmissioncl/:name',component:MissionformclientComponent},
  {path:'gestionmissioncc/:name',component:  MissionformccComponent},
  {path:'mcc/:name',component:MissionchargedecompteComponent},
  {path:'mna/:name',component:MissionnonaffecteComponent},
  {path:'nonvalide/:name',component:NonvalideComponent},

  {path:'logintok',component:LoginComponent},






















  {path:'',redirectTo:'accueil',pathMatch:'full'},
];

@NgModule({
  declarations: [
    AppComponent,
    ListconsultantsComponent,
    ConsultantformComponent,

    AccueilComponent,

    LoginformComponent,

    ProfiladminComponent,

    GestionconsultantsComponent,

    ProfilconsultantComponent,

    MissionformComponent,

    UserComponent,

    ErreurComponent,

    CompetencesComponent,

    ExperienceComponent,

    ExperienceformComponent,

    CompetencesformComponent,

    ProfilclientComponent,

    ProfilChargeDeCompteComponent,

    Consultantform2Component,

    MissionsComponent,

    Missionsform2Component,

    ProfilpartenaireComponent,

    ListconsultantssComponent,

    ProfilrecruteurComponent,

    MissionclientComponent,

    MissionformclientComponent,

    MissionchargedecompteComponent,

    MissionformccComponent,

    MissionnonaffecteComponent,

    NonvalideComponent,

    LoginComponent,

   // LoginComponent,
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule,FormsModule,Ng2Webstorage,HttpClientModule
  ],
  providers: [ConsultantService,MissionService,AuthGuard,CompetencesService,ExperienceService,FileserviceService,ClientService,ChargedecompteService,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
