import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ListconsultantsComponent } from './components/listconsultants/listconsultants.component';
import { ConsultantformComponent } from './components/consultantform/consultantform.component';
import {RouterModule, Routes} from "@angular/router";
import { ConsultantService} from './shared-service/consultant.service';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
//import { LoginComponent } from './components/login/login.component';
import {Ng2Webstorage} from 'ngx-webstorage';
import { ProfiladminComponent } from './components/profiladmin/profiladmin.component';

const appRoutes:Routes=[
  {path:'op',component:ConsultantformComponent},
  {path:'list',component:ListconsultantsComponent},
  //{path:'login',component:LoginComponent},

  {path:'',redirectTo:'list',pathMatch:'full'


  },



];

@NgModule({
  declarations: [
    AppComponent,
    ListconsultantsComponent,
    ConsultantformComponent,
    ProfiladminComponent,
   // LoginComponent,
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule,FormsModule,Ng2Webstorage
  ],
  providers: [ConsultantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
