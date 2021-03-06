import { Component, OnInit } from '@angular/core';
import {Mission} from "../../modules/mission.module";
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {MissionService} from "../../shared-service/mission.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FileserviceService} from "../../shared-service/fileservice.service";
import {ClientService} from "../../shared-service/client.service";
import {Client} from "../../modules/client.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-missionclient',
  templateUrl: './missionclient.component.html',
  styleUrls: ['./missionclient.component.css']
})
export class MissionclientComponent implements OnInit {
  mission:any;
  private missions:any;
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String='';
  recup:any;
  cli: any;
  url:string;
  url2:string;
  m:any;
  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.userco = this.route.snapshot.params.name;
    this.authservice.getClientbyLogin(this.userco).subscribe((data) =>{
        this.cli=data;
        console.log(this.cli.userId);
        //
       // this.url=this.cli.fileDownloadUri;
        this.authservice.recherchemissionsbyclient(this.cli.userId,"",this.currentpage,this.size).subscribe( (data) => {
          this.missions = data;
          console.log(this.missions);
          this.pages=new Array(data.totalPages);

        }, (error) => {
          this.authservice.logout();
          this.router.navigateByUrl('/logintok');
          console.log(error);
        })
      }, (error) => {
      this.authservice.logout();
      this.router.navigateByUrl('/logintok');
        console.log(error);}

    )


   // console.log('UserLogin '+ this.consultantService.getUserLoggedIn());
    this.authservice.supprimerMissionAuto();

  }
  editerMission(m)
  {
    this.authservice.settermission(m);
    this.authservice.setterlogin(this.userco);

    console.log("mission est "+m);
    this.router.navigate(['/gestionmissioncl/'+this.userco]);

  }
  deleteMission(m,userco)
  {
    /*
     *  const confirm = window.confirm('Are you sure you want to delete this User?') ;
     if (confirm === true) {
     this.userservice.supprUser(u.id).subscribe(data => {
     this.pageUsers.content.splice(
     this.pageUsers.content.indexOf(u), 1) ;
     } , err => {
     console.log(err) ;
     }) ;
     }
     * */
    const confirm = window.confirm('Are you sure you want to delete this Mission?') ;
    if (confirm === true) {
      this.authservice.deleteMission(m.idMission).subscribe((data) => {
        //  this.missions.splice(1,1);

        console.log(data);
      }, (error) => {
        console.log(error);
      });
      // this.missions.toString().slice(this.missions.toString().indexOf(m), 1);
      this.missions.content.splice(
        this.missions.content.indexOf(m), 1) ;

      // window.history.go(0);
      /*this.consultantService.setterlogin(this.userco);
       window.location.reload();
       this.userco = this.consultantService.getterlogin();*/


      // this.userco=userco;

    }
  }
  doSearch()
  {

    this.authservice.getClientbyLogin(this.userco).subscribe((data) =>{
        this.cli=data;
        console.log(this.cli.userId);

        this.authservice.recherchemissionsbyclient(this.cli.userId,this.motCle,this.currentpage,this.size).subscribe( (data) => {
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
  desactiver(id) {
    this.authservice.desactiverMission(id).subscribe((data) => {
      console.log(data);
      this.mission = data;
      window.location.reload();


    });
  }
  activer(id)
  {
    this.authservice.activerMission(id).subscribe((data)=>{
      console.log(data);
      this.mission=data;
      window.location.reload();


    });
  }


  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

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

  newMission()
  {
    //L'instruction let permet de déclarer une variable dont la portée est celle du bloc courant,
    // éventuellement en initialisant sa valeur.

    let m= new Mission();
    this.authservice.settermission(m);
    this.authservice.setterlogin(this.userco);
    this.router.navigate(['/gestionmissioncl/'+this.userco]);
  }
}
