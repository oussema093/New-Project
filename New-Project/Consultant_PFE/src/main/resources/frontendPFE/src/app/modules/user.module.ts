/**
 * Created by Lenovo on 28/05/2018.
 */
export class User {
  userId: number = null;
  nom: string = '';
  prenom: string = '';
  dateNaissance: Date = null;
  email: string = '';
  userName: string = '';
  password: string = '';
  role:string='';
  created:Date=null;
  validation:boolean=null;
  etat: boolean = false;

  constructor() {
  }

}
