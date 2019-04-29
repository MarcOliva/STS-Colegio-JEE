package com.oliva.marc.web.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.service.impl.EducationDegreeService;

@Named
@ViewScoped
public class EducationDegreeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EducationDegreeService educationDegreeService;
	private EducationDegree educationDegree;
	
	private List<EducationDegree> grades;
	
	@PostConstruct
	public void init() {
		educationDegree = new EducationDegree();	
		
	}
	
	public void loadGrades() {
		try {
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public EducationDegree getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(EducationDegree educationDegree) {
		this.educationDegree = educationDegree;
	}

	public List<EducationDegree> getGrades() {
		return grades;
	}

	public void setGrades(List<EducationDegree> grades) {
		this.grades = grades;
	}
	
	
	
}
