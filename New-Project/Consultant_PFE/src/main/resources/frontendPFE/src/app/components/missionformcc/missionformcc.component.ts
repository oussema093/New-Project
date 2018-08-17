import { Component, OnInit } from '@angular/core';
import {Mission} from "../../modules/mission.module";
import {ChargeDeCompte} from "../../modules/chargedecompte.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ClientService} from "../../shared-service/client.service";
import {Router} from "@angular/router";
import {MissionService} from "../../shared-service/mission.service";
import {FileserviceService} from "../../shared-service/fileservice.service";
import {ChargedecompteService} from "../../shared-service/chargedecompte.service";
import {isNullOrUndefined} from "util";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-missionformcc',
  templateUrl: './missionformcc.component.html',
  styleUrls: ['./missionformcc.component.css']
})
export class MissionformccComponent implements OnInit {


  mission: any;
  userco: String;
  mode:number=1;
  recup:any;
  m:any;
  cc:any;
  f:File;
  constructor( private router: Router,private authservice:AuthenticationService) {
  }

  ngOnInit() {
    this.mission = this.authservice.gettermission();
    this.userco=this.authservice.getterlogin();

  }
  public fileEvent($event) {
    const fileSelected: File = $event.target.files[0];
    this.f = $event.target.files[0];

    //this.f=$event.target.files[0];
    // this.fileSelected=$event.target.files[0];


  }

  processForm() {

    if(isNullOrUndefined(this.mission.idMission)){

      this.authservice.getChargeDeComptetbyLogin(this.userco).subscribe(data=> {
        this.cc = data;
        console.log("heeeeeeeyyeyysysyxyxyxy  "+this.cc.userName)
        // this.competences.setConsultant(this.consultant);
        this.mission.chargedecompte = this.cc;
        /* this.missionservice.createMission(this.mission).subscribe((data)=>{
         console.log(data);
         this.mission=data;

         });*/
if(this.f!=null)
{this.authservice.create(this.f)
  .subscribe((response) => {
      this.recup=response;
      console.log('set any success actions...');
      console.log(this.recup.fileDownloadUri);

      this.mission.fileDownloadUri=this.recup.fileDownloadUri;
      this.authservice.createMission(this.mission).subscribe((data) => {
        //  console.log(consultant);
        this.m = data;


      });


      //
      //

      return response;
    },
    (error) => {
      console.log('set any error actions...');
    });}
    if(this.f==null)
    {
      this.authservice.createMission(this.mission).subscribe((data) => {
        //  console.log(consultant);
        this.m = data;


      });
    }





      });
    }

    else
    {
      if(this.f!=null) {
        this.authservice.create(this.f)
          .subscribe((response) => {
              this.recup = response;
              console.log('set any success actions...');
              console.log(this.recup.fileDownloadUri);

              this.mission.fileDownloadUri = this.recup.fileDownloadUri;
              this.authservice.updateMission(this.mission).subscribe((data) => {
                //  console.log(consultant);
                this.m = data;


              });


              //
              //

              return response;
            },
            (error) => {
              console.log('set any error actions...');
            });

      }


      //});
      if(this.f==null) {
        this.authservice.updateMission(this.mission).subscribe((data) => {
          console.log(data);
          this.mission = data;

        });

      }




    }

    this.mode=2;


  }
  retour()
  {
    console.log("redirection");
    this.router.navigate(['/mcc/'+this.userco]);
  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
