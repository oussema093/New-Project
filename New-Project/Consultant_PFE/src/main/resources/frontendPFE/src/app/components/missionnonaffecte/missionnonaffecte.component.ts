import { Component, OnInit } from '@angular/core';
import {Mission} from "../../modules/mission.module";
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {MissionService} from "../../shared-service/mission.service";
import {FileserviceService} from "../../shared-service/fileservice.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-missionnonaffecte',
  templateUrl: './missionnonaffecte.component.html',
  styleUrls: ['./missionnonaffecte.component.css']
})
export class MissionnonaffecteComponent implements OnInit {

  mission:any;
  private missions:any;
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String='';
  recup:any;
  cons: any;
  url:string;
  url2:string;
  m:any;
  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.userco = this.route.snapshot.params.name;


    this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
        this.cons=data;
        console.log(this.cons.userId);
        this.url=this.cons.fileDownloadUri;
        this.authservice.getMissionsBynonaffecte("",this.currentpage,this.size).subscribe( (data) => {
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


   // console.log('UserLogin '+ this.authservice.getUserLoggedIn());
    this.authservice.supprimerMissionAuto();
  }

  saffecter(m) {
    this.authservice.getUserbyLogin(this.userco).subscribe(data => {
      if (data.validation == false) {
        const confirm = window.confirm('votre compte n est pas encore validé par le charge de compte');
        if (confirm === true) {
          this.router.navigateByUrl('mna/' + this.userco);
        }

      }
      else{


      const confirm = window.confirm('tu es sur de s affecter a cette mission?');
      if (confirm === true) {
        this.authservice.getUserbyLogin(this.userco).subscribe((data) => {
            this.cons = data;
            console.log(this.cons.userId);
            m.consultant = this.cons;

            this.authservice.saffecter(m).subscribe(data => {
                this.authservice.affecter(m, this.cons).subscribe(data => {

                })
                this.router.navigateByUrl('/consultant/' + this.userco);

              }
            )

          }, (error) => {
            console.log(error);
          }
        )


      }
    }
    })

  }


  doSearch()
  {

    this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
        this.cons=data;
        console.log(this.cons.userId);

        this.authservice.getMissionsBynonaffecte(this.motCle,this.currentpage,this.size).subscribe( (data) => {
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
  public fileEvent($event) {
    const fileSelected: File = $event.target.files[0];
    //this.f=$event.target.files[0];
    // this.fileSelected=$event.target.files[0];
    this.authservice.create(fileSelected)
      .subscribe((response) => {
          this.recup=response;
          console.log('set any success actions...');
          console.log(this.recup.fileDownloadUri);
          this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
              this.cons=data;
              this.cons.fileDownloadUri=this.recup.fileDownloadUri;
              console.log(this.cons.userId);
              this.authservice.updateConsultant(this.cons).subscribe((consultant) => {
                console.log(consultant);
                this.cons = consultant;


              });

            }, (error) => {
              console.log(error);}

          )
          //
          //

          return response;
        },
        (error) => {
          console.log('set any error actions...');
        });


  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
