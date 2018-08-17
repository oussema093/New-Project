import { Component, OnInit } from '@angular/core';
import {Competences} from "../../modules/competences.module";
import {CompetencesService} from "../../shared-service/competences.service";
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-competences',
  templateUrl: './competences.component.html',
  styleUrls: ['./competences.component.css']
})
export class CompetencesComponent implements OnInit {
  competences:any;
  listCompetences:any;
  position:number=0;
  motCle:String="";
  size:number=5;
  currentpage:number=0;
  pages:Array<number>;
  userco:String='';

  cons: Consultant;

  constructor(private router:Router,private route:ActivatedRoute,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.userco = this.route.snapshot.params.name;

    this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
        this.cons=data;
        console.log(this.cons.userId);

        this.authservice.recherchecompsbyconsultant(this.cons.userId,"",this.currentpage,this.size).subscribe( (data) => {
          this.listCompetences = data;
          console.log(this.listCompetences);
          this.pages=new Array(data.totalPages);

        }, (error) => {
          console.log(error);
          this.authservice.logout();
          this.router.navigateByUrl('/logintok');
        })
      }, (error) => {
      this.authservice.logout();
      this.router.navigateByUrl('/logintok');
        console.log(error);}

    )


  }

  editerCompetences(c)
  {
    this.authservice.settercomp(c);
    this.authservice.setterlogin(this.userco);

    console.log("Competence est "+c);
    this.router.navigate(['/competencesform/'+this.userco]);

  }
  deleteComptetences(c)
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
    const confirm = window.confirm('Are you sure you want to delete this Competence?') ;
    if (confirm === true) {
      this.authservice.deleteCompetences(c.idCompetence).subscribe((data) => {
        //  this.missions.splice(1,1);

        console.log(data);
      }, (error) => {
        console.log(error);
      });
      // this.missions.toString().slice(this.missions.toString().indexOf(m), 1);
      this.listCompetences.content.splice(
        this.listCompetences.content.indexOf(c), 1) ;

      // window.history.go(0);
      /*this.consultantService.setterlogin(this.userco);
       window.location.reload();
       this.userco = this.consultantService.getterlogin();*/


      // this.userco=userco;

    }
  }
  doSearch()
  {

    this.authservice.getUserbyLogin(this.userco).subscribe((data) =>{
        this.cons=data;
        console.log(this.cons.userId);

        this.authservice.recherchecompsbyconsultant(this.cons.userId,this.motCle,this.currentpage,this.size).subscribe( (data) => {
          this.listCompetences = data;
          console.log(this.listCompetences);
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
newCompetence()
{
  let c= new Competences();
  this.authservice.setterlogin(this.userco);

  this.authservice.settercomp(c);
  this.router.navigate(['/competencesform/'+this.userco]);

}
}
