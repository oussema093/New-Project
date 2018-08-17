import { Component, OnInit } from '@angular/core';
import {Competences} from "../../modules/competences.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";
import {CompetencesService} from "../../shared-service/competences.service";
import {isNullOrUndefined} from "util";
import {Consultant} from "../../modules/consultant.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-competencesform',
  templateUrl: './competencesform.component.html',
  styleUrls: ['./competencesform.component.css']
})
export class CompetencesformComponent implements OnInit {
mode:number=1;
  competences: any;
  userco: String;
  consultant:any;



  constructor(private router: Router,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.competences=this.authservice.gettercomp();
    this.userco=this.authservice.getterlogin();

  }
  processForm()
  {

    if(isNullOrUndefined(this.competences.idCompetence)){

      this.authservice.getUserbyLogin(this.userco).subscribe(data=>
      {
        this.consultant=data;
        // this.competences.setConsultant(this.consultant);
        this.competences.consultant=this.consultant;

        this.authservice.createCompetences(this.competences).subscribe((data)=>{
          console.log(data);
          this.competences=data;


        });

      })


    }
    else
    {
      this.authservice.updateCompetences(this.competences).subscribe((data)=>{
        console.log(data);
        this.competences=data;

      });



    }

    this.mode=2;



  }
  retour()
  {
    this.router.navigate(['/competences/'+this.userco]);


  }
}
