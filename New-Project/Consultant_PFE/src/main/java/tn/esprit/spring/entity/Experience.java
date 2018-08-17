package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Experience implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   	private Long idExperience;
	private String intitulePoste;
	private String nomEntreprise;
	private String lieu;
	@Temporal(TemporalType.DATE)

	private Date dateDebut;
	@Temporal(TemporalType.DATE)

	private Date dateFin;
//	@ManyToOne
//	private Competences competences;
	
	@ManyToOne
	private Consultant consultant;
	private static final long serialVersionUID = 1L;
	

	public Experience() {
		super();
	}


	
public Experience(Long idExperience, String intitulePoste, String nomEntreprise, String lieu, Date dateDebut,
			Date dateFin, Consultant consultant) {
		super();
		this.idExperience = idExperience;
		this.intitulePoste = intitulePoste;
		this.nomEntreprise = nomEntreprise;
		this.lieu = lieu;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.consultant = consultant;
	}

	//	public Competences getCompetences() {
//		return competences;
//	}
//	public void setCompetences(Competences competences) {
//		this.competences = competences;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getIdExperience() {
		return idExperience;
	}
	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}
	public String getIntitulePoste() {
		return intitulePoste;
	}
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public Consultant getConsultant() {
		return consultant;
	}



	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	
	
	
	

}
