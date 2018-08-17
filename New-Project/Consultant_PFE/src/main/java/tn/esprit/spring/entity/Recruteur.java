package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class Recruteur extends User implements Serializable {
	


	@OneToMany(mappedBy="recruteur2",cascade=CascadeType.PERSIST)
	private List<Mission>listmissions;
	@OneToMany(mappedBy="recruteur",cascade=CascadeType.PERSIST)
	private List<Consultant>listConsultant;

	private static final long serialVersionUID = 1L;

	

	public Recruteur() {
		super();
	}

	public List<Mission> getListmissions() {
		return listmissions;
	}

	public void setListmissions(List<Mission> listmissions) {
		this.listmissions = listmissions;
	}

	public List<Consultant> getListConsultant() {
		return listConsultant;
	}

	public void setListConsultant(List<Consultant> listConsultant) {
		this.listConsultant = listConsultant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
