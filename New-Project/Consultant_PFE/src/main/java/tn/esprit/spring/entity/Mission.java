package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mission implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idMission;
	private String description;
	private Float facturation;
	private String fileDownloadUri;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;	
	private String documents;
	private boolean etat;
	@ManyToOne
	private Consultant consultant;
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Recruteur recruteur2;
	@ManyToOne
	private ChargeDeCompte chargedecompte;
	

	
	
	public Mission() {
		super();
	}
	

	public Mission(Long idMission, String description, Float facturation, Date dateDebut, String documents,
			boolean etat, Consultant consultant) {
		super();
		this.idMission = idMission;
		this.description = description;
		this.facturation = facturation;
		this.dateDebut = dateDebut;
		this.documents = documents;
		this.etat = etat;
		this.consultant = consultant;
	}


	public Mission(String description, Float facturation, Date dateDebut, String documents, boolean etat,
			Consultant consultant) {
		super();
		this.description = description;
		this.facturation = facturation;
		this.dateDebut = dateDebut;
		this.documents = documents;
		this.etat = etat;
		this.consultant = consultant;
	}
	public Mission(String description, Float facturation, Date dateDebut,Date dateFin, String documents, boolean etat,
			Consultant consultant) {
		super();
		this.description = description;
		this.facturation = facturation;
		this.dateDebut = dateDebut;
		this.documents = documents;
		this.etat = etat;
		this.consultant = consultant;
		this.dateFin=dateFin;
	}
	public Mission(String description, Float facturation, Date dateDebut,Date dateFin, String documents, boolean etat,
			Client c) {
		super();
		this.description = description;
		this.facturation = facturation;
		this.dateDebut = dateDebut;
		this.documents = documents;
		this.etat = etat;
		this.client = c;
		this.dateFin=dateFin;
	}
	
	public Mission(String description, Float facturation, Date dateDebut,Date dateFin, String documents, boolean etat,
			ChargeDeCompte c) {
		super();
		this.description = description;
		this.facturation = facturation;
		this.dateDebut = dateDebut;
		this.documents = documents;
		this.etat = etat;
		this.chargedecompte = c;
		this.dateFin=dateFin;
	}

	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	public Recruteur getRecruteur() {
		return recruteur2;
	}
	public void setRecruteur(Recruteur recruteur) {
		this.recruteur2 = recruteur;
	}
	public ChargeDeCompte getChargedecompte() {
		return chargedecompte;
	}
	public void setChargedecompte(ChargeDeCompte chargedecompte) {
		this.chargedecompte = chargedecompte;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;

	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getFacturation() {
		return facturation;
	}
	public void setFacturation(Float facturation) {
		this.facturation = facturation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDocuments() {
		return documents;
	}
	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public String getFileDownloadUri() {
		return fileDownloadUri;
	}


	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Recruteur getRecruteur2() {
		return recruteur2;
	}


	public void setRecruteur2(Recruteur recruteur2) {
		this.recruteur2 = recruteur2;
	}

}
