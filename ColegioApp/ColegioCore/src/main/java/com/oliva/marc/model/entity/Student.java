package com.oliva.marc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "paternal_lastname", length = 20, nullable = false)
	private String paternalLastname;
	
	@Column(name ="maternal_lastname", length = 20, nullable = false)
	private String maternalLastname;
	
	@Column(name = "dni", precision = 8, nullable = false)
	private Integer dni;
	
	@ManyToOne
	@JoinColumn(name = "empowered_id", nullable = false)
	private Empowered empowered;
	
	@ManyToOne
	@JoinColumn(name = "education_degree_id", nullable = false)
	private EducationDegree educationDegree;

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

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Empowered getEmpowered() {
		return empowered;
	}

	public void setEmpowered(Empowered empowered) {
		this.empowered = empowered;
	}

	public EducationDegree getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(EducationDegree educationDegree) {
		this.educationDegree = educationDegree;
	}
}
