package net.ycod3r.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.ycod3r.validators.Phone;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String prenom;
	private String nom;
	private String numeroLong;
	@Phone
	private String numeroCourt;
	@Phone
	private String portable;
	@ManyToOne(fetch = FetchType.EAGER)
	private Department departement;
	
	
	
	public Employee() {
		super();
	}



	public Employee(String prenom, String nom, String numeroLong, String numeroCourt, String portable) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numeroLong = numeroLong;
		this.numeroCourt = numeroCourt;
		this.portable = portable;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getNumeroLong() {
		return numeroLong;
	}



	public void setNumeroLong(String numeroLong) {
		this.numeroLong = numeroLong;
	}



	public String getNumeroCourt() {
		return numeroCourt;
	}



	public void setNumeroCourt(String numeroCourt) {
		this.numeroCourt = numeroCourt;
	}



	public String getPortable() {
		return portable;
	}



	public void setPortable(String portable) {
		this.portable = portable;
	}



	public Department getDepartement() {
		return departement;
	}



	public void setDepartement(Department departement) {
		this.departement = departement;
	}
	
	
}
