package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecommanderConsultant implements Serializable {

	@EmbeddedId
	private RecommanderConsultantID recommanderconsultantid;
	private Date datederecommandation;
	@ManyToOne
	@JoinColumn(name="idConsultantPK",insertable= false,updatable =false)
	private Consultant consultant;
	@ManyToOne
	@JoinColumn(name="idClientPK",insertable= false, updatable= false)
	private Client client;
	private static final long serialVersionUID = 1L;
	
	public RecommanderConsultantID getRecommanderconsultantid() {
		return recommanderconsultantid;
	}
	public void setRecommanderconsultantid(RecommanderConsultantID recommanderconsultantid) {
		this.recommanderconsultantid = recommanderconsultantid;
	}
	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getDatederecommandation() {
		return datederecommandation;
	}
	public void setDatederecommandation(Date datederecommandation) {
		this.datederecommandation = datederecommandation;
	}

	
	
	
}
