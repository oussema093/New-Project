//package tn.esprit.spring;
//
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import tn.esprit.Mail.NewClass;
//import tn.esprit.spring.entity.Admin;
//import tn.esprit.spring.entity.ChargeDeCompte;
//import tn.esprit.spring.entity.Client;
//import tn.esprit.spring.entity.Competences;
//import tn.esprit.spring.entity.Consultant;
//import tn.esprit.spring.entity.Experience;
//import tn.esprit.spring.entity.Mission;
//import tn.esprit.spring.entity.Partenaire;
//import tn.esprit.spring.entity.Recruteur;
//import tn.esprit.spring.repository.AdminRepository;
//import tn.esprit.spring.repository.ChargeDeCompteRepository;
//import tn.esprit.spring.repository.ConsultantRepository;
//import tn.esprit.spring.repository.MissionRepository;
//import tn.esprit.spring.repository.PartenaireRepository;
//import tn.esprit.spring.repository.RecruteurRepository;
//import tn.esprit.spring.service.interfaces.IClient;
//import tn.esprit.spring.service.interfaces.IComptence;
//import tn.esprit.spring.service.interfaces.IExperience;
//@SpringBootApplication
//public class Test implements CommandLineRunner {
//
//	@Autowired
//	ConsultantRepository cons;
////	@Resource
////	StorageService storageService;
//	@Autowired
//	AdminRepository adminrepo;
//	@Autowired
//	MissionRepository mrepo;
//	@Autowired
//	IComptence comp;
//	@Autowired
//	IExperience exp;
//	@Autowired
//	IClient cli;
//	@Autowired
//	ChargeDeCompteRepository cr;
//	@Autowired
//	PartenaireRepository pr;
//	@Autowired
//	RecruteurRepository rr;
//	
//
//	public static void main(String[] args) {
//		
//		
//		
//		// TODO Auto-generated method stub
//		SpringApplication.run(Test.class, args);
//		
//
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
//		Date d=new Date();
//		
//		
//		
//		Consultant c1=new Consultant(2,"ASSA","FOX",df.parse("15/03/1995"),"fox.assa@ss.fr","fathi","1111","consultant",d,"Centre urbain nord",true,"parSemaine",false,"Orange","./assets/theme/images/people/ouss.jpg");
//	    Consultant c2=new Consultant(3,"SEZAR","REX",df.parse("17/12/1990"),"sezar.rex@ss.net","rex","2222","consultant",d,"Lac1",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//	    Consultant c3=new Consultant(4,"aaa","aaaa",df.parse("17/12/1987"),"aaaa.aaaa@ss.net","aaa","2222","consultant",d,"Lac2",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//	    Consultant c4=new Consultant(5,"bbbbb","bbbbb",df.parse("17/12/1977"),"bbbbbb.b@ss.net","bbb","2222","consultant",d,"Manouba",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//	    Consultant c5=new Consultant(6,"cccc","cccc",df.parse("17/12/1945"),"c.c@ss.net","ccc","2222","consultant",d,"Charguia",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//	    Consultant c6=new Consultant(7,"dddd","dddd",df.parse("17/12/1999"),"d.d@ss.net","ddd","2222","consultant",d,"Pole Technologie Ghazela",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//	    Consultant c7=new Consultant(8,"eeee","eeee",df.parse("17/12/2001"),"ee.ee@ss.net","eee","2222","consultant",d,"Lac2",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//        Consultant c8=new Consultant(9,"fffff","ffff",df.parse("17/12/1544"),"fff.f@ss.net","fff","2222","consultant",d,"Lac1",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//        Consultant c9=new Consultant(10,"gggg","gggg",df.parse("17/12/1255"),"g.g@ss.net","ggg","2222","consultant",d,"Centre urbain nord",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//        Consultant c10=new Consultant(11,"hhhh","hhhh",df.parse("17/12/1914"),"h.h@ss.net","hhh","2222","consultant",d,"Manouba",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//        Consultant c11=new Consultant(12,"qqqqq","qqqqq",df.parse("17/12/1990"),"q.q@ss.net","nnnn","2222","consultant",d,"Nassr",true,"parJours",false,"Oredo","./assets/theme/images/people/ouss.jpg");
//
//      c1.setValidation(true);
//      c2.setValidation(true);
//      c3.setValidation(true);
//      c4.setValidation(true);
//      c5.setValidation(true);
//      c6.setValidation(true);
//      c7.setValidation(true);
//      c8.setValidation(false);
//      c9.setValidation(false);
//      c10.setValidation(false);
//      c11.setValidation(false);
//
//
//        
//        adminrepo.save(new Admin("Ammar","Oussema",df.parse("26/04/1993"),"oussema.ammar@esprit.tn","ouss","0000","admin",d,"./assets/theme/images/people/ouss.jpg"));
//		cons.save(new Consultant("ASSA","FOX",df.parse("15/03/1995"),"ammaroussema1993@gmail.com","fathi","1111","consultant",d,"Centre urbain nord",true,"parSemaine",false,"Orange","./assets/consultants/1.jpg",true));
//		cons.save(new Consultant("SEZAR","REX",df.parse("17/12/1990"),"ammaroussema1993@gmail.com","rex","2222","consultant",d,"Lac1",true,"parJours",false,"Oredo","./assets/consultants/2.jpg",true));
//		cons.save(new Consultant("aaa","aaaa",df.parse("17/12/1987"),"aaaa.aaaa@ss.net","aaa","2222","consultant",d,"Lac2",true,"parJours",false,"Oredo","./assets/consultants/3.jpg",true));
//		cons.save(new Consultant("bbbbb","bbbbb",df.parse("17/12/1977"),"bbbbbb.b@ss.net","bbb","2222","consultant",d,"Manouba",true,"parJours",false,"Oredo","./assets/consultants/4.jpg",true));
//		cons.save(new Consultant("cccc","cccc",df.parse("17/12/1945"),"c.c@ss.net","ccc","2222","consultant",d,"Charguia",true,"parJours",false,"Oredo","./assets/consultants/5.jpg",true));
//		cons.save(new Consultant("dddd","dddd",df.parse("17/12/1999"),"d.d@ss.net","ddd","2222","consultant",d,"Pole Technologie Ghazela",true,"parJours",false,"Oredo","./assets/consultants/6.jpg",true));
//		cons.save(new Consultant("eeee","eeee",df.parse("17/12/2001"),"ee.ee@ss.net","eee","2222","consultant",d,"Lac2",true,"parJours",false,"Oredo","./assets/consultants/7.jpg",true));
//		cons.save(new Consultant("fffff","ffff",df.parse("17/12/1544"),"fff.f@ss.net","fff","2222","consultant",d,"Lac1",true,"parJours",false,"Oredo","./assets/consultants/8.jpg",false));
//		cons.save(new Consultant("gggg","gggg",df.parse("17/12/1255"),"g.g@ss.net","ggg","2222","consultant",d,"Centre urbain nord",true,"parJours",false,"Oredo","./assets/consultants/9.jpg",false));
//		cons.save(new Consultant("hhhh","hhhh",df.parse("17/12/1914"),"h.h@ss.net","hhh","2222","consultant",d,"Manouba",true,"parJours",false,"Oredo","./assets/consultants/10.jpeg",false));
//		cons.save(new Consultant("qqqqq","qqqqq",df.parse("17/12/1990"),"q.q@ss.net","nnnn","2222","consultant",d,"Nassr",true,"parJours",false,"Oredo","./assets/consultants/11.jpg",false));
//		
//		Client cl1=new Client("kacem", "nizar", df.parse("15/03/1999"), "ammaroussema1993@gmail.com", "nizar", "1111", "client", "./assets/theme/images/people/ouss.jpg", true);
//		ChargeDeCompte cc=new ChargeDeCompte();
//
//		cc.setUserName("mm");
//		cc.setPassword("1111");
//		cc.setRole("chargeDeCompte");
//		cc.setEmail("ammaroussema1993@gmail.com");
//		cli.addClient(cl1);
//		cr.save(cc);
//
//		Partenaire p=new Partenaire();
//		p.setUserName("song");
//		p.setPassword("1111");
//		p.setRole("partenaire");
//		p.setEmail("ammaroussema1993@gmail.com");
//		pr.save(p);
//
//		Recruteur r=new Recruteur();
//		r.setUserName("rec");
//		r.setPassword("1111");
//		r.setRole("recruteur");
//		rr.save(r);
//		
//		mrepo.save(new Mission("mission rouge",2.2f,df.parse("15/03/2018"),df.parse("20/09/2018"),"c//d",true,c1));
//		mrepo.save(new Mission("mission vert",10.5f,df.parse("25/10/2018"),df.parse("22/09/2018"),"c//d",true,c1));
//		mrepo.save(new Mission("mission orange",7.3f,df.parse("07/11/2018"),df.parse("23/09/2018"),"c//d",false,c1));
//		mrepo.save(new Mission("mission bleu",20.5f,df.parse("04/09/2018"),df.parse("24/10/2018"),"c//d",false,c1));
//		mrepo.save(new Mission("mission rose",2.2f,df.parse("15/03/2018"),df.parse("25/11/2018"),"c//d",true,c1));
//		mrepo.save(new Mission("mission jaune",2.2f,df.parse("15/03/2018"),df.parse("26/09/2018"),"c//d",true,c1));
//		mrepo.save(new Mission("mission impossible",2.2f,df.parse("15/03/2018"),df.parse("27/10/2018"),"c//d",true,c1));
//		mrepo.save(new Mission("mission zero",15.2f,df.parse("15/03/2018"),df.parse("28/10/2018"),"c//d",false,c2));
//		mrepo.save(new Mission("mission one x",25.4f,df.parse("15/12/2019"),df.parse("29/10/2018"),"c//d",true,c2));
//		mrepo.save(new Mission("mission pro",44.2f,df.parse("15/03/2018"),df.parse("21/06/2018"),"c//d",true,c2));
//		mrepo.save(new Mission("mission ccc",7.75f,df.parse("14/12/2018"),df.parse("22/06/2018"),"c//d",false,c2));
//		mrepo.save(new Mission("mission roxxxuge",2.25f,df.parse("15/03/2018"),df.parse("23/06/2018"),"c//d",true,c3));
//		mrepo.save(new Mission("mission rouge",2.27f,df.parse("15/03/2018"),df.parse("24/06/2018"),"c//d",true,c3));
//		mrepo.save(new Mission("mission zzzz",15.22f,df.parse("22/06/2018"),df.parse("25/06/2018"),"c//d",true,c3));
//		mrepo.save(new Mission("mission qqqq",42.57f,df.parse("30/07/2018"),df.parse("26/06/2018"),"c//d",false,c3));
//		mrepo.save(new Mission("mission ssss",22.2f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,c3));
//
//		mrepo.save(new Mission("mission client",22.2f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cl1));
//		mrepo.save(new Mission("mission program",57.4f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cl1));
//		mrepo.save(new Mission("mission giga",57.4f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cl1));
//
//		mrepo.save(new Mission("mission chargecompte",57.4f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cc));
//		mrepo.save(new Mission("mission program charge compte",57.4f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cc));
//		mrepo.save(new Mission("mission progressive",57.4f,df.parse("15/03/2018"),df.parse("27/06/2018"),"c//d",false,cc));
//
//	/*	 java.util.Date today = new java.util.Date();
//		 Date d1;
//    d1= new Timestamp(today.getTime());
//
//		storageService.deleteAll();
//		storageService.init();*/
//		Competences comp1=new Competences(null,"Developpeur JAVAEE","Developpement Informatique","JAVAEE",c1);
//		Competences comp2=new Competences(null,"Developpeur Angular","Developpement Informatique","Angular",c1);
//		Competences comp3=new Competences(null,"Developpeur symfony","Developpement Informatique","Symphony",c1);
//		Competences comp4=new Competences(null,"Developpeur .NET","Developpement Informatique",".NET",c1);
//		Competences comp5=new Competences(null,"Developpeur android","Developpement Mobile","Android",c1);
//
//		Competences comp6=new Competences(null,"Developpeur JAVAEE","Developpement Informatique","JAVAEE",c2);
//		Competences comp7=new Competences(null,"Developpeur Angular","Developpement Informatique","Angular",c2);
//		Competences comp8=new Competences(null,"Developpeur symfony","Developpement Informatique","Symphony",c2);
//		Competences comp9=new Competences(null,"Developpeur .NET","Developpement Informatique",".NET",c2);
//		Competences comp10=new Competences(null,"Developpeur android","Developpement Mobile","Android",c2);
//
//		Competences comp11=new Competences(null,"Developpeur JAVAEE","Developpement Informatique","JAVAEE",c3);
//		Competences comp111=new Competences(null,"Developpeur symfony","Developpement Informatique","Symphony",c3);
//
//		Competences comp12=new Competences(null,"Developpeur JAVAEE","Developpement Informatique","JAVAEE",c4);
//		Competences comp122=new Competences(null,"Developpeur symfony","Developpement Informatique","Symphony",c4);
//
//		
//
//		
//
//
//		
//		comp.addComptence(comp1);
//		comp.addComptence(comp2);
//		comp.addComptence(comp3);
//		comp.addComptence(comp4);
//		comp.addComptence(comp5);
//		comp.addComptence(comp6);
//		comp.addComptence(comp7);
//		comp.addComptence(comp8);
//		comp.addComptence(comp9);
//		comp.addComptence(comp10);
//
//		comp.addComptence(comp11);
//		comp.addComptence(comp12);
//		
//		comp.addComptence(comp111);
//		comp.addComptence(comp122);
//	
//
//		
//		Experience exp1=new Experience(null, "ConsultantJavaEE", "Vermeg", "Ariana",df.parse("15/03/2015"),df.parse("15/08/2015"),c1);
//		Experience exp2=new Experience(null, "Developpeur Angular", "WingedHorse", "LAC",df.parse("15/08/2015"),df.parse("15/12/2015"),c1);
//		Experience exp3=new Experience(null, "Developpeur symfony", "XTENSUS", "Pole Technologie ghazela",df.parse("15/12/2015"),df.parse("16/06/2016"),c1);
//		Experience exp4=new Experience(null, "Developpeur .NET", "Tunisie Telecom", "Ariana",df.parse("17/06/2016"),df.parse("18/08/2016"),c1);
//		Experience exp5=new Experience(null, "Developpeur android", "Orange", "Ariana",df.parse("18/08/2017"),df.parse("27/12/2017"),c1);
//		
//		Experience exp6=new Experience(null, "ConsultantJavaEE", "Vermeg", "Ariana",df.parse("15/03/2013"),df.parse("15/08/2013"),c2);
//		Experience exp7=new Experience(null, "Developpeur Angular", "WingedHorse", "LAC",df.parse("15/08/2013"),df.parse("15/12/2013"),c2);
//		Experience exp8=new Experience(null, "Developpeur symfony", "XTENSUS", "Pole Technologie ghazela",df.parse("15/12/2013"),df.parse("16/06/2014"),c2);
//		Experience exp9=new Experience(null, "Developpeur .NET", "Tunisie Telecom", "Ariana",df.parse("17/06/2014"),df.parse("18/08/2014"),c2);
//		Experience exp10=new Experience(null, "Developpeur android", "Orange", "Ariana",df.parse("18/08/2015"),df.parse("27/12/2015"),c2);
//exp.addExperience(exp1);
//exp.addExperience(exp2);
//exp.addExperience(exp3);
//exp.addExperience(exp4);
//exp.addExperience(exp5);
//exp.addExperience(exp6);
//exp.addExperience(exp7);
//exp.addExperience(exp8);
//exp.addExperience(exp9);
//exp.addExperience(exp10);
//
//
///*String a, b, x, msg;
//a= "ammaroussema1993@gmail.com";
//        String[] to={"ammaroussema1993@gmail.com"};
//b= "realmadrid1993";
//x= "Consultant PFE";
//msg= "vous etes recommandé";
//NewClass.sendFromGMail(a, b, to, x, msg);*/
//
//
//	}
//
//}
