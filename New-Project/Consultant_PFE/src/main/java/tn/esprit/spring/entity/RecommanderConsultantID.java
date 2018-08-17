package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RecommanderConsultantID implements Serializable{

	private Long idConsultantPK;
	private Long idClientPK;
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getIdConsultantPK() {
		return idConsultantPK;
	}
	public void setIdConsultantPK(Long idConsultantPK) {
		this.idConsultantPK = idConsultantPK;
	}
	public Long getIdClientPK() {
		return idClientPK;
	}
	public void setIdClientPK(Long idClientPK) {
		this.idClientPK = idClientPK;
	}

}
