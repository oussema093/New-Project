package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Partenaire extends User implements Serializable {
	



	private boolean etat;
	private String ModeleRemuneration;
	
	@ManyToOne
	private ChargeDeCompte chargedecompte;
	@OneToMany(mappedBy="partenaire")
	private List<PartenaireRecommandeConsultant>listrecommandation;
	private static final long serialVersionUID = 1L;
	

	
	public Partenaire() {
		super();
	}
	public Partenaire(boolean etat, String modeleRemuneration) {
		super();
		this.etat = etat;
		ModeleRemuneration = modeleRemuneration;
	}
	public List<PartenaireRecommandeConsultant> getListrecommandation() {
		return listrecommandation;
	}
	public void setListrecommandation(List<PartenaireRecommandeConsultant> listrecommandation) {
		this.listrecommandation = listrecommandation;
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
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getModeleRemuneration() {
		return ModeleRemuneration;
	}
	public void setModeleRemuneration(String modeleRemuneration) {
		ModeleRemuneration = modeleRemuneration;
	}
	
	
}
