package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import tn.esprit.spring.entity.Role;
//
//
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String email;
	private String userName;
	
	private String password;
	private String role;
	@CreationTimestamp
	private Date created;
	private String photo;
	private byte[]img;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection	<Role> roles = new ArrayList<>();
private int salaire=2500;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	


	public User( String nom, String prenom, Date dateNaissance, String email,String userName, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
	}
	public User( String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,Date created) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
		this.role=role;
		this.created=created;
	}
	public User( String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,Date created,String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
		this.role=role;
		this.created=created;
		this.photo=photo;
	}
	public User( String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
		this.role=role;
		this.photo=photo;
	}
	public User( long id ,String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,Date created,String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
		this.role=role;
		this.created=created;
		this.photo=photo;
		this.userId=id;
	}
	public User( long id ,String nom, String prenom, Date dateNaissance, String email,String userName, String password,String role,Date created,String photo,byte[]img) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email=email;
		this.userName = userName;
		this.password = password;
		this.role=role;
		this.created=created;
		this.photo=photo;
		this.userId=id;
		this.img=img;
	}


	public User(String nom, String prenom, String userName, String password, Date created) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.userName = userName;
		this.password = password;
		this.created = created;
	}
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(Long userId, String userName, String password, Collection<Role> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public byte[] getImg() {
		return img;
	}



	public void setImg(byte[] img) {
		this.img = img;
	}



	public int getSalaire() {
		return salaire;
	}



	public void setSalaire(int solde) {
		this.salaire = solde;
	}



	public Collection<Role> getRoles() {
		return roles;
	}



	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}



}
//
