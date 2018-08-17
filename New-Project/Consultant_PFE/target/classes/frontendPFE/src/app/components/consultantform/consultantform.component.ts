import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {Router} from "@angular/router";
import {isNullOrUndefined, isUndefined} from "util";

@Component({
  selector: 'app-consultantform',
  templateUrl: './consultantform.component.html',
  styleUrls: ['./consultantform.component.css']
})
export class ConsultantformComponent implements OnInit {
  consultant: Consultant=new Consultant();
  mode:number=1;

  constructor(private consultantService: ConsultantService, private router: Router) {
  }

  ngOnInit() {
    this.consultant = this.consultantService.getter();
  }

  processForm() {
    if(isNullOrUndefined(this.consultant.userId)){
      this.consultantService.createConsultant(this.consultant).subscribe((consultant)=>{
        console.log(consultant);
        this.consultant=consultant;

      });

    }
    else
    {

      this.consultantService.updateConsultant(this.consultant).subscribe((consultant)=>{
        console.log(consultant);
        this.consultant=consultant;


      });


    }

    this.mode=2;


  }
  retour()
  {
    console.log("redirection");
    this.router.navigate(['/list']);
  }
}
