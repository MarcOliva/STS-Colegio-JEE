package com.oliva.marc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empowereds")
public class Empowered implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "paternal_lastname", length = 20, nullable = false)
	private String paternalLastname;
	
	@Column(name = "maternal_lastname", length = 20, nullable = false)
	private String maternalLastname;
	
	@Column(name = "birthdate", nullable = false)
	private String birthdate;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "dni", precision = 8, nullable = false)
	private Integer dni;
	
	@Column(name = "phone", precision = 9, nullable = false)
	private Integer phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaternalLastname() {
		return paternalLastname;
	}

	public void setPaternalLastname(String paternalLastname) {
		this.paternalLastname = paternalLastname;
	}

	public String getMaternalLastname() {
		return maternalLastname;
	}

	public void setMaternalLastname(String maternalLastname) {
		this.maternalLastname = maternalLastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}
}
