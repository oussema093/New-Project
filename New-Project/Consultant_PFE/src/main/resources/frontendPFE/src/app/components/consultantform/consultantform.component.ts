import { Component, OnInit } from '@angular/core';
import {Consultant} from "../../modules/consultant.module";
import {ConsultantService} from "../../shared-service/consultant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {isNullOrUndefined, isUndefined} from "util";
import {HttpClient} from "@angular/common/http";
import {noUndefined} from "@angular/compiler/src/util";
import {AuthenticationService} from "../../shared-service/authentication.service";

@Component({
  selector: 'app-consultantform',
  templateUrl: './consultantform.component.html',
  styleUrls: ['./consultantform.component.css']
})
export class ConsultantformComponent implements OnInit {
  consultant: any;
  mode:number=1;
  name='';
  selectedFile:File=null;
  pathBasic:string="/assets/consultants/";

  constructor( private router: Router,private route:ActivatedRoute,private http:HttpClient,private authservice:AuthenticationService) {
  }

  ngOnInit() {

    this.consultant = this.authservice.gettercons();
    this.name=this.route.snapshot.params.name;

  }

  processForm() {
if(isNullOrUndefined(this.consultant.userId)) {

    this.consultant.setPhoto(this.pathBasic);

    this.authservice.createConsultant(this.consultant).subscribe((consultant) => {
      console.log(consultant);
      this.consultant = consultant;

    });

  }
  else {


    //    this.consultant.setPhoto(this.pathBasic);

    this.authservice.updateConsultant(this.consultant).subscribe((consultant) => {
      console.log(consultant);
      this.consultant = consultant;


    });


  }

  this.mode = 2;


  }
  retour()
  {
    console.log("redirection");
    this.router.navigate(['/admin/'+this.name]);
  }
  onFileSelected(event)
  {
this.selectedFile=<File>event.target.files[0];
const fd=new FormData();
fd.append('image',this.selectedFile,this.selectedFile.name);
   this.pathBasic= this.pathBasic+event.target.files[0].name;
console.log(event.target.files[0].name);

  }
  logout()
  {
    this.authservice.logout();//
    this.router.navigateByUrl('/logintok');

  }
}
