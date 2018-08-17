package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Competences implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompetence;
	private String posteActuelle;
	private String domaineTravail;
	private String infoCompetences;
//	@OneToMany(mappedBy="competences",cascade=CascadeType.PERSIST)
//	private List<Experience>listExperience;
	@ManyToOne
	private Consultant consultant;
	private static final long serialVersionUID = 1L;
	

	public Competences() {
		super();
	}
	public Competences(Long idCompetence, String posteActuelle, String domaineTravail, String infoCompetences,
			 Consultant consultant) {
		super();
		this.idCompetence = idCompetence;
		this.posteActuelle = posteActuelle;
		this.domaineTravail = domaineTravail;
		this.infoCompetences = infoCompetences;
		this.consultant = consultant;
	}
	public Long getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(Long idCompetence) {
		this.idCompetence = idCompetence;
	}
	public String getPosteActuelle() {
		return posteActuelle;
	}
	public void setPosteActuelle(String posteActuelle) {
		this.posteActuelle = posteActuelle;
	}
	public String getDomaineTravail() {
		return domaineTravail;
	}
	public void setDomaineTravail(String domaineTravail) {
		this.domaineTravail = domaineTravail;
	}
	public String getInfoCompetences() {
		return infoCompetences;
	}
	public void setInfoCompetences(String infoCompetences) {
		this.infoCompetences = infoCompetences;
	}
	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

}
