import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../entities/consultant";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  consultant: Consultant=new Consultant();
  msg:String='';
  constructor(private consultantService: ConsultantService, private router: Router) { }

  ngOnInit() {
  }
  login()
  {
 /*this.consultantService.loginConsultant(this.consultant).subscribe((data)=>{
      console.log(data);
      this.msg=data;

    });*/
  //  this.consultantService.loginConsultant(this.consultant);

  }
}
