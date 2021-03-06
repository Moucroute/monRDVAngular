package monRDV.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@Column(name = "email", unique=true)
	@JsonView(Views.ViewCommon.class)
	private String email;
	
	@Column(name = "telephone")
	@JsonView(Views.ViewUtilisateur.class)
	private String telephone;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation")
	@JsonView(Views.ViewCommon.class)
	private Date dateCreation;

	@Column(name = "mot_de_passe")
	@JsonView(Views.ViewUtilisateur.class)
	private String motDePasse;

	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewUtilisateur.class)
	private Profil profil;

	@OneToMany(mappedBy = "utilisateur")
	private List<Patient> patients = new ArrayList<Patient>();

	@OneToMany(mappedBy = "utilisateur")
	private List<RendezVous> rendezVous = new ArrayList<RendezVous>();

	@OneToOne
	@JoinColumn(name = "praticien_id")
	@JsonView(Views.ViewPraticien.class)
	private Praticien praticien;
	

	public Utilisateur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public List<Patient> getListPatient() {
		return patients;
	}

	public void setListPatient(List<Patient> patients) {
		this.patients = patients;
	}


	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	

}
