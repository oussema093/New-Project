package tn.esprit.spring.entity;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PartenaireRecommandeConsultant {
	@EmbeddedId
	private RecommanderConsultantID recommanderconsultantid;
	private Date datederecommandation;
	@ManyToOne
	@JoinColumn(name="idConsultantPK",insertable= false,updatable =false)
	private Consultant consultant;
	@ManyToOne
	@JoinColumn(name="idPartenairePK",insertable= false, updatable= false)
	private Client partenaire;
	private static final long serialVersionUID = 1L;
	public RecommanderConsultantID getRecommanderconsultantid() {
		return recommanderconsultantid;
	}
	public void setRecommanderconsultantid(RecommanderConsultantID recommanderconsultantid) {
		this.recommanderconsultantid = recommanderconsultantid;
	}
	public Date getDatederecommandation() {
		return datederecommandation;
	}
	public void setDatederecommandation(Date datederecommandation) {
		this.datederecommandation = datederecommandation;
	}
	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	public Client getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(Client partenaire) {
		this.partenaire = partenaire;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
