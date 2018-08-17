package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class File implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	 private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;
	@OneToOne(mappedBy="cv")
	private Consultant consultant;
	@ManyToOne
	private ChargeDeCompte chargedecompte;
	private static final long serialVersionUID = 1L;
	public File(Long id, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public File(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public File() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	public Consultant getConsultant() {
		return consultant;
	}
	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
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


}
