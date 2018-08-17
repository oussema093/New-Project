import {User} from "./user.module";
import * as Stream from "stream";
import {Competences} from "./competences.module";
export class Consultant extends User{
  adresse:string='';
  modeleRemuneration: string = "";
  disponibilite: boolean = false;
  nomSociete: string = "";
  private photo: string = '';
  salaire:number=null;
  fileDownloadUri:string;
  //img:FormData;//
  listcompetence:Competences[];


  setPhoto(value: string) {
    this.photo = value;
  }

  constructor() {
    super();
  }

}
