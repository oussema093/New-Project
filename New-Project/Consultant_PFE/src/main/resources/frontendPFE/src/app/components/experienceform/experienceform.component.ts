import { Component, OnInit } from '@angular/core';
import {Experience} from "../../modules/experience.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";
import {ExperienceService} from "../../shared-service/experience.service";
import {isNullOrUndefined} from "util";
import {Consultant} from "../../modules/consultant.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-experienceform',
  templateUrl: './experienceform.component.html',
  styleUrls: ['./experienceform.component.css']
})
export class ExperienceformComponent implements OnInit {
  mode:number=1;
  userco: String;
experience:any;
consultant:any;

  constructor( private router: Router,private authservice:AuthenticationService ) { }


  ngOnInit() {
    this.experience=this.authservice.getterexp();
    this.userco=this.authservice.getterlogin();
  }
  processForm()
  {

    if(isNullOrUndefined(this.experience.idExperience)){
      this.authservice.getUserbyLogin(this.userco).subscribe(data=> {
        this.consultant = data;
        // this.competences.setConsultant(this.consultant);
        this.experience.consultant = this.consultant;


        this.authservice.createExperience(this.experience).subscribe((data) => {
          console.log(data);
          this.experience = data;


        });
      })
    }
    else
    {

      this.authservice.updateExperience(this.experience).subscribe((data)=>{
        console.log(data);
        this.experience=data;
        console.log("phase finale "+this.experience);

      });



    }


    this.mode=2;




  }

  retour()
  {
    this.router.navigate(['/experiences/'+this.userco]);
    console.log("login: "+this.userco);

  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
