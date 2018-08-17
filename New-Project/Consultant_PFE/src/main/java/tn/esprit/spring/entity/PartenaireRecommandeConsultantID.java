package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PartenaireRecommandeConsultantID implements Serializable{
	private Long idConsultantPK;
	private Long idPartenairePK;
	private static final long serialVersionUID = 1L;
	public Long getIdConsultantPK() {
		return idConsultantPK;
	}
	public void setIdConsultantPK(Long idConsultantPK) {
		this.idConsultantPK = idConsultantPK;
	}
	public Long getIdPartenairePK() {
		return idPartenairePK;
	}
	public void setIdPartenairePK(Long idPartenairePK) {
		this.idPartenairePK = idPartenairePK;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
