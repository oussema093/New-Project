import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";
import {User} from "../../modules/user.module";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  user: User=new User();
  userco:User=new User();

//

  constructor( private router: Router,private authservice:AuthenticationService) { }

  ngOnInit() {
  }
  authentification(){
    this.authservice.loginUser(this.user.userName,this.user.password).subscribe(
      (data) => {
        console.log(data);
        this.userco = data
       if(this.userco.etat==false || this.userco.validation==false){
//
          this.router.navigate(['404']);

        }
        if(this.userco!=null && this.userco.role=="admin" ){
          this.authservice.setterlogin(this.user.userName);

          this.router.navigate(['/admin/'+this.user.userName]);
        //  this.authservice.setUserLoggedIn();


        }
        if(this.userco!=null && this.userco.role=="chargeDeCompte" ){
          this.authservice.setterlogin(this.user.userName);

          this.router.navigate(['/chargeCompte/'+this.user.userName]);
         // this.authservice.setUserLoggedIn();


        }
        if(this.userco!=null && this.userco.role=="partenaire" ){
          this.authservice.setterlogin(this.user.userName);

          this.router.navigate(['/partenaire/'+this.user.userName]);
         // this.authservice.setUserLoggedIn();


        }
        if(this.userco!=null && this.userco.role=="recruteur" ){
          this.authservice.setterlogin(this.user.userName);

          this.router.navigate(['/recruteur/'+this.user.userName]);
        //  this.authservice.setUserLoggedIn();


        }

        if(this.userco!=null && this.userco.role=="client"){
          // this.consultantService.setterlogin(this.user.userName);
         // this.authservice.setUserLoggedIn();
          this.router.navigate(['/client/'+this.user.userName]);
          // this.router.navigate(['/users/'+this.userco.userName]);

        }
        if(this.userco!=null && this.userco.role=="consultant" && this.userco.etat==true && this.userco.validation==true){
         // this.consultantService.setterlogin(this.user.userName);
//this.authservice.setUserLoggedIn();
         this.router.navigate(['/consultant/'+this.user.userName]);
         // this.router.navigate(['/users/'+this.userco.userName]);

        }


      }, (error) => {
        console.log(error);
      })
  }


}
