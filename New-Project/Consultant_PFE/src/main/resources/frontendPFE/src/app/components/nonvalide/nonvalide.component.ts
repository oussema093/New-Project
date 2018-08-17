import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-nonvalide',
  templateUrl: './nonvalide.component.html',
  styleUrls: ['./nonvalide.component.css']
})
export class NonvalideComponent implements OnInit {
  consultant:any;
  consultants:any;//Consultant[];
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String;
  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) {
  }

  ngOnInit() {

    this.authservice.getConsultantsnonvalide(this.motCle,this.currentpage,this.size).subscribe(
      (consultants) => {
        console.log(consultants);
        this.consultants = consultants;
        this.pages=new Array(consultants.totalPages);

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

  valider(c) {
    const confirm = window.confirm('veux tu vraiment valider ce consultant?');
    if (confirm === true) {
      this.authservice.valider(c.userId).subscribe(
        data => {
          this.router.navigateByUrl("/chargeCompte/" + this.userco);
        }
      )
    }
  }



  doSearch()
  {
    this.authservice.getConsultantsnonvalide(this.motCle,this.currentpage,this.size).subscribe(
      (consultants) => {
        console.log(consultants);
        this.consultants = consultants;

      }, (error) => {
        console.log(error);
      })

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
