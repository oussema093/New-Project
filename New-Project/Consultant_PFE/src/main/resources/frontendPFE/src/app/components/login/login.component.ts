import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../shared-service/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mode:number=0;
  constructor(private authService:AuthenticationService, private router:Router ) { }

  ngOnInit() {
  }
  onLogin(dataForm)
  {

    this.authService.login(dataForm).subscribe(resp=>{
        let jwt=resp.headers.get('Authorization');
        console.log(jwt);
        this.authService.saveToken(jwt);
        this.authService.getUserbyLogin(dataForm.userName).subscribe((data)=>{
          if(this.authService.isConsultant()==true) {
            if (data.etat == false) {
              this.router.navigateByUrl("404");
            }
          }
        })
if(this.authService.isAdmin()==true)
{ this.router.navigateByUrl('/admin/'+dataForm.userName);}
        if(this.authService.isClient()==true)
        { this.router.navigateByUrl('/client/'+dataForm.userName);}
        if(this.authService.isConsultant()==true)
        { this.router.navigateByUrl('/consultant/'+dataForm.userName);}
        if(this.authService.isCC()==true)
        { this.router.navigateByUrl('/chargeCompte/'+dataForm.userName);}
        if(this.authService.isPartenaire()==true)
        { this.router.navigateByUrl('/partenaire/'+dataForm.userName);}
        if(this.authService.isRecruteur()==true)
        { this.router.navigateByUrl('/recruteur/'+dataForm.userName);}
      },
      err=>{
        this.mode=1;
      })

  }
}
