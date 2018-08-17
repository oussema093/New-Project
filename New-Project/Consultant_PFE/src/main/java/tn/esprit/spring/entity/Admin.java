package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;

@Entity
public class Admin extends User  implements Serializable{

	@OneToMany(mappedBy="admin",cascade=CascadeType.PERSIST)
	private List<Consultant>consultants;


	private static final long serialVersionUID = 1L;

	

	

	public Admin(String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,Date created,String photo) {
		super(nom,  prenom,  dateNaissance,  email, userName,  password, role, created, photo);
		
	}





	public Admin() {
		super();
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}
