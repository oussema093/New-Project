import {Consultant} from "./consultant.module";
import {Competences} from "./competences.module";
/**
 * Created by Lenovo on 30/07/2018.
 */
export class Experience
{
  idExperience:number=null;
  intitulePoste:string="";
  nomEntreprise:string="";
  lieu:string="";
  dateDebut:Date=null;
  dateFin:Date=null;
  consultant:Consultant=null;
  constructor() {
  }

}
