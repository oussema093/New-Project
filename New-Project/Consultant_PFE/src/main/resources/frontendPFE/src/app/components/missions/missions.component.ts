import { Component, OnInit } from '@angular/core';
import {Mission} from "../../modules/mission.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {MissionService} from "../../shared-service/mission.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Consultant} from "../../modules/consultant.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrls: ['./missions.component.css']
})
export class MissionsComponent implements OnInit {

  mission:any;
  private missions:any;
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String='';

  cons: any;

  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.userco = this.route.snapshot.params.name;



        this.authservice.getMissions("",this.currentpage,this.size).subscribe( (data) => {
          this.missions = data;
          console.log(this.missions);
          this.pages=new Array(data.totalPages);

        }, (error) => {
          this.authservice.logout();
          this.router.navigateByUrl('/logintok');
          console.log(error);
        })


  //  console.log('UserLogin '+ this.consultantService.getUserLoggedIn());
    this.authservice.supprimerMissionAuto();
  }

  editerMission(m)
  {
    this.authservice.settermission(m);
    this.authservice.setterlogin(this.userco);

    console.log("mission est "+m);
    this.router.navigate(['/gestionmission2/'+this.userco]);

  }

  doSearch()
  {

    this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
        this.cons=data;

        this.authservice.getMissions(this.motCle,this.currentpage,this.size).subscribe( (data) => {
          this.missions = data;
          console.log(this.missions);
          this.pages=new Array(data.totalPages);

        }, (error) => {
          console.log(error);
        })
      }, (error) => {
        console.log(error);}

    )
  }
  chercher()
  {
    this.doSearch();
  }






  goToPage(i:number)
  {
    this.currentpage=i;
    this.doSearch();
  }

  login()
  {
    this.router.navigate(['/login']);

  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
