import { Component, OnInit } from '@angular/core';
import {Mission} from "../../modules/mission.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";
import {MissionService} from "../../shared-service/mission.service";
import {isNullOrUndefined} from "util";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-missionsform2',
  templateUrl: './missionsform2.component.html',
  styleUrls: ['./missionsform2.component.css']
})
export class Missionsform2Component implements OnInit {
  mission: any;
  userco: String;
  mode:number=1;

  constructor( private router: Router,private authservice:AuthenticationService) {
  }

  ngOnInit() {
    this.mission = this.authservice.gettermission();
    this.userco=this.authservice.getterlogin();

  }

  processForm() {
    if(isNullOrUndefined(this.mission.idMission)){
      this.authservice.createMission(this.mission).subscribe((data)=>{
        console.log(data);
        this.mission=data;

      });

    }
    else
    {

      this.authservice.updateMission(this.mission).subscribe((data)=>{
        console.log(data);
        this.mission=data;

      });



    }

    this.mode=2;


  }
  retour()
  {
    console.log("redirection");
    this.router.navigate(['/missions/'+this.userco]);
  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
