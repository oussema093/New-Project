package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;


@Entity
public class ChargeDeCompte extends User implements Serializable {


	@OneToMany(mappedBy="chargedecompte",cascade=CascadeType.PERSIST)
	private List<Mission>listmissions;
	@OneToMany(mappedBy="chargedecompte",cascade=CascadeType.PERSIST)
	private List<File>listcv;
	@OneToMany(mappedBy="chargedecompte",cascade=CascadeType.PERSIST)
	private List<Partenaire>listpartenaire;
	@OneToMany(mappedBy="chargedecompte",cascade=CascadeType.PERSIST)
	private List<Consultant>listConsultants;


	
	public ChargeDeCompte() {
		super();
	}
	public ChargeDeCompte(Long id,String nom,String prenom, Date dateNaissance,String email,String userName,String password,String role,Date created,String photo) {
		super(id, nom, prenom, dateNaissance, email, userName, password, role, created, photo);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;

}
