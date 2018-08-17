import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../modules/user.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-profiladmin',
  templateUrl: './Profiladmin.component.html',
  styleUrls: ['./Profiladmin.component.css']
})
export class ProfiladminComponent implements OnInit {
  consultant:any;
 private  consultants:any;//Consultant[];
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String;
  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) {
  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
  ngOnInit() {

    this.authservice.getConsultants(this.motCle,this.currentpage,this.size).subscribe(
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

  deleteConsultant(c) {
    const confirm = window.confirm('Are you sure you want to delete this consultant?') ;
    if (confirm === true) {
      // console.log("index :"+this.consultants.indexOf(c));
      console.log("id est:" + c.userId);
      this.authservice.deleteConsultant(c.userId).subscribe((data) => {

        this.consultants.content.splice(
          this.consultants.content.indexOf(c), 1);
        console.log(data);
      }, (error) => {
        console.log(error);
      });
      // window.history.go(0);
      //this.consultants.splice(this.consultants.indexOf(c),1);

    }
  }
  updateConsultant(c)
  {

    this.authservice.settercons(c);
    console.log(c);
    this.router.navigate(['/op/'+this.userco]);

  }
  newConsultant()
  {
    //L'instruction let permet de déclarer une variable dont la portée est celle du bloc courant,
    // éventuellement en initialisant sa valeur.

    let c= new Consultant();
    this.authservice.settercons(c);
    this.router.navigate(['/op/'+this.userco]);
  }

  doSearch()
  {
    this.authservice.getConsultants(this.motCle,this.currentpage,this.size).subscribe(
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
  desactiverConsultant(id)
  {
    this.authservice.desactiverConsultant(id).subscribe((data) => {
      console.log(data);
      this.consultant = data;


    });
    window.location.reload();

  }
  activerConsultant(id)
  {
    this.authservice.activerConsultant(id).subscribe((data) => {
      console.log(data);
      this.consultant = data;


    });
    window.location.reload();

  }



}
