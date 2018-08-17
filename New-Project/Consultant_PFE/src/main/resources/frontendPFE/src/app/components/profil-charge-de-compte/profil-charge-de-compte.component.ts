import { Component, OnInit } from '@angular/core';
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Consultant} from "../../modules/consultant.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-profil-charge-de-compte',
  templateUrl: './profil-charge-de-compte.component.html',
  styleUrls: ['./profil-charge-de-compte.component.css']
})
export class ProfilChargeDeCompteComponent implements OnInit {
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

    this.authservice.getConsultantsvalides(this.motCle,this.currentpage,this.size).subscribe(
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

  updateConsultant(c)
  {

    this.authservice.settercons(c);
    console.log(c);
    this.router.navigate(['/op2/'+this.userco]);

  }


  doSearch()
  {
    this.authservice.getConsultantsvalides(this.motCle,this.currentpage,this.size).subscribe(
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
  nonvalider(c)
  {
    const confirm = window.confirm('veux tu vraiment annuler la validation de ce consultant?');
    if (confirm === true) {
      this.authservice.nonvalider(c.userId).subscribe(
        data => {
          this.router.navigateByUrl("/nonvalide/" + this.userco);
        }
      )
    }
  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }

}
