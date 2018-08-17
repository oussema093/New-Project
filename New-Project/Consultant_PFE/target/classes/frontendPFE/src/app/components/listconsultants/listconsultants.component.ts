import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-listconsultants',
  templateUrl: './listconsultants.component.html',
  styleUrls: ['./listconsultants.component.css']
})
export class ListconsultantsComponent implements OnInit {
  consultant:Consultant=new Consultant();
  consultants:Consultant[];
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  constructor(private consultantService: ConsultantService,private router:Router) {
  }

  ngOnInit() {

    this.consultantService.getConsultants(this.motCle,this.currentpage,this.size).subscribe(
      (consultants) => {
        console.log(consultants);
        this.consultants = consultants;
        this.pages=new Array(consultants.totalPages);

      }, (error) => {
        console.log(error);
      })
  }
  rechercheConsultantbyID(id)
  {
    this.consultantService.getConsultantByid(id).subscribe(
      (consultant) => {
        this.consultant = consultant;

      }, (error) => {
        console.log(error);
      })

  }

  deleteConsultant(c) {
    // console.log("index :"+this.consultants.indexOf(c));
console.log("id est:"+c.userId);
    this.consultantService.deleteConsultant(c.userId).subscribe((data)=>{
      //  this.consultants.splice(this.consultants.indexOf(c),1);

      console.log(data);
    }, (error) => {
      console.log(error);
    });
    window.history.go(0);
    //this.consultants.splice(this.consultants.indexOf(c),1);


  }
  updateConsultant(c)
  {

    this.consultantService.setter(c);
    this.router.navigate(['/op']);

  }
  newConsultant()
  {
    //L'instruction let permet de déclarer une variable dont la portée est celle du bloc courant,
    // éventuellement en initialisant sa valeur.

    let c= new Consultant();
    this.consultantService.setter(c);
    this.router.navigate(['/op']);
  }
  doSearch()
  {
    this.consultantService.getConsultants(this.motCle,this.currentpage,this.size).subscribe(
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
}
