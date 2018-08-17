import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CompetencesService} from "../../shared-service/competences.service";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-profilclient',
  templateUrl: './profilclient.component.html',
  styleUrls: ['./profilclient.component.css']
})
export class ProfilclientComponent implements OnInit {
  motClex:string;
  motCley:string;
  consultant:any;
  consultants:any;//Consultant[];
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String;
  competences:any;
  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) {
  }

  ngOnInit() {

   /* this.consultantService.getConsultants(this.motCle,this.currentpage,this.size).subscribe(
      (consultants) => {
        console.log(consultants);
        this.consultants = consultants;
        this.pages=new Array(consultants.totalPages);

      }, (error) => {
        console.log(error);
      })*/
    this.authservice.valide(this.motCle,this.currentpage,this.size).subscribe(
      (data) => {
        this.competences = data;
        this.pages=new Array(data.totalPages);

      }, (error) => {
        this.authservice.logout();
        this.router.navigateByUrl('/logintok');
        console.log(error);
      })

    this.userco = this.route.snapshot.params.name;

  }
  rechercheConsultantbyID(id)
  {
    this.authservice.getConsultantByid(id).subscribe(
      (consultant) => {
        this.consultant = consultant;

      }, (error) => {
        console.log(error);
      })

  }

  recommanderConsultant(c) {
    const confirm = window.confirm('Are you sure you want to recommand this Consultant?') ;
    if (confirm === true) {
      this.authservice.recommander(c).subscribe(
        (data) => {

        }, (error) => {
          console.log(error);
        })
    }

  }



  doSearch()
  {
    this.authservice.valide(this.motCle,this.currentpage,this.size).subscribe(
      (data) => {
        this.competences = data;
        this.pages=new Array(data.totalPages);

      }, (error) => {
        console.log(error);
      })

  }
  doSearch2()
  {
    this.authservice.rechercheCompetences2(this.motCley,this.currentpage,this.size).subscribe(
      (data) => {
        this.competences = data;
        this.pages=new Array(data.totalPages);

      }, (error) => {
        console.log(error);
      })

  }
  chercher()
  {
    this.doSearch();
  }
chercher2()
{
  this.doSearch2();
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
