import {Consultant} from "./consultant.module";
import {ChargeDeCompte} from "./chargedecompte.module";
import {Client} from "./client.module";
/**
 * Created by Lenovo on 29/05/2018.
 */
export class Mission
{
     idMission :number=null;
     description :string='';
     facturation : number=0;
     dateDebut:Date=null;
     dateFin:Date =null;
     documents:string='';
     etat :boolean=false;
     consultant:Consultant=null;
  chargedecompte:ChargeDeCompte=null;
     client:Client;
  fileDownloadUri:string=null;
   //Recruteur recruteur2;
  // ChargeDeCompte chargedecompte;
  constructor() {
  }



}
