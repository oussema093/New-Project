package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import tn.esprit.spring.entity.Experience;



@Entity
public class Consultant extends User  implements Serializable  {

    private String adresse;
	private Boolean etat;
	private String ModeleRemuneration;
	private boolean disponibilite;
	private String nomSociete;
	private String fileDownloadUri;
	private boolean validation;

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Consultant parentConsultant;
	@OneToMany(mappedBy="parentConsultant")
	private List<Consultant> listsousconsultant;
	@OneToMany(mappedBy="consultant",cascade=CascadeType.PERSIST)
	private List<Mission>listmissions;
	@OneToMany(mappedBy="consultant",cascade=CascadeType.PERSIST)
	private List<Competences>listcompetence;
	@OneToMany(mappedBy="consultant",cascade=CascadeType.PERSIST)
	private List<Experience>listexp;
	@OneToMany(mappedBy="consultant")
	private List<RecommanderConsultant>listrecommandation;
	@OneToMany(mappedBy="consultant")
	private List<PartenaireRecommandeConsultant>listrecommandation1;
	
	@OneToOne
	private File cv;
	@ManyToOne
	private Recruteur recruteur;
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private ChargeDeCompte chargedecompte;
	
	
	public Consultant() {
		super();
	}
	

	public Consultant(String nom, String prenom, Date dateNaissance, String email, String login, String pwd,String role,String adresse,
			Boolean etat, String modeleRemuneration, boolean disponibilite, String nomSociete,String photo) {
          super(nom,prenom,dateNaissance,email,login,pwd);
		//		this.nom=nom;
//		this.prenom=prenom;
//		this.dateNaissance=dateNaissance;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
		this.adresse=adresse;
		this.etat = etat;
		this.ModeleRemuneration = modeleRemuneration;
		this.disponibilite = disponibilite;
		this.nomSociete = nomSociete;
	
	}
	
	public Consultant(String nom, String prenom, Date dateNaissance, String email, String login, String pwd,String role,Date created,String adresse,
			Boolean etat, String modeleRemuneration, boolean disponibilite, String nomSociete,String photo) {
          super(nom,prenom,dateNaissance,email,login,pwd,role,created,photo);
		//		this.nom=nom;
//		this.prenom=prenom;
//		this.dateNaissance=dateNaissance;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
		this.adresse=adresse;
		this.etat = etat;
		this.ModeleRemuneration = modeleRemuneration;
		this.disponibilite = disponibilite;
		this.nomSociete = nomSociete;
	
	}
	public Consultant(String nom, String prenom, Date dateNaissance, String email, String login, String pwd,String role,Date created,String adresse,
			Boolean etat, String modeleRemuneration, boolean disponibilite, String nomSociete,String photo,boolean validation) {
          super(nom,prenom,dateNaissance,email,login,pwd,role,created,photo);
		//		this.nom=nom;
//		this.prenom=prenom;
//		this.dateNaissance=dateNaissance;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
		this.adresse=adresse;
		this.etat = etat;
		this.ModeleRemuneration = modeleRemuneration;
		this.disponibilite = disponibilite;
		this.nomSociete = nomSociete;
	this.validation=validation;
	}
	public Consultant(String nom, String prenom, Date dateNaissance, String email, String login, String pwd,String role,
			Boolean etat, String modeleRemuneration, boolean disponibilite, String nomSociete,String photo) {
          super(nom,prenom,dateNaissance,email,login,pwd);
		//		this.nom=nom;
//		this.prenom=prenom;
//		this.dateNaissance=dateNaissance;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
		
		this.etat = etat;
		this.ModeleRemuneration = modeleRemuneration;
		this.disponibilite = disponibilite;
		this.nomSociete = nomSociete;
		this.setPhoto(photo);
	
	}
	
	public Consultant(String nom, String prenom, String email, String login, String pwd, String modeleRemuneration, String nomSociete) {
		super();
//		this.nom=nom;
//		this.prenom=prenom;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
	
		this.ModeleRemuneration = modeleRemuneration;
		this.nomSociete = nomSociete;
	
	}
	
	public Consultant(long id,String nom, String prenom, Date dateNaissance, String email, String login, String pwd,String role,Date created,String adresse,
			Boolean etat, String modeleRemuneration, boolean disponibilite, String nomSociete,String photo) {
          super(id,nom,prenom,dateNaissance,email,login,pwd,role,created,photo);
		//		this.nom=nom;
//		this.prenom=prenom;
//		this.dateNaissance=dateNaissance;
//		this.email=email;
//		this.userName=login;
//		this.password=pwd;
		this.adresse=adresse;
		this.etat = etat;
		this.ModeleRemuneration = modeleRemuneration;
		this.disponibilite = disponibilite;
		this.nomSociete = nomSociete;
	
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public String getModeleRemuneration() {
		return ModeleRemuneration;
	}
	public void setModeleRemuneration(String modeleRemuneration) {
		ModeleRemuneration = modeleRemuneration;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getFileDownloadUri() {
		return fileDownloadUri;
	}


	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}


	public boolean isValidation() {
		return validation;
	}


	public void setValidation(boolean validation) {
		this.validation = validation;
	}


	
	
	

}
