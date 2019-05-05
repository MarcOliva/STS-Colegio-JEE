package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.service.impl.EducationDegreeService;

@Named
@ViewScoped
public class EducationDegreeController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EducationDegreeService educationDegreeService;
	
	private EducationDegree educationDegree;
	private EducationDegree educationDegreeSelec;
	private List<EducationDegree> educationDegrees;
	
	@PostConstruct
	public void init() {
		educationDegree = new EducationDegree();
		educationDegreeSelec = new EducationDegree();
		loadEducationDegrees();
	}
	
	public void loadEducationDegrees() {
		try {
			this.educationDegrees = educationDegreeService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveEducationDegree() {
		try {
			if (educationDegree.getId() != null) {
				educationDegreeService.update(educationDegree);
				System.out.println("Registro actualizado exitosamente");				
			} else {
				educationDegreeService.insert(educationDegree);
				System.out.println("Registro guardado exitosamente");
			}
			loadEducationDegrees();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editEducationDegree() {
		try {
			if (this.educationDegreeSelec != null) {
				this.educationDegree = educationDegreeSelec;
			} else {
				System.out.println("Debe seleccionar un grado educativo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectEducationDegree(SelectEvent e) {
		this.educationDegreeSelec = (EducationDegree) e.getObject();
	}
	
	public void clearForm() {
		this.educationDegree = new EducationDegree();
		this.educationDegreeSelec = null;
	}

	public EducationDegree getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(EducationDegree educationDegree) {
		this.educationDegree = educationDegree;
	}

	public EducationDegree getEducationDegreeSelec() {
		return educationDegreeSelec;
	}

	public void setEducationDegreeSelec(EducationDegree educationDegreeSelec) {
		this.educationDegreeSelec = educationDegreeSelec;
	}

	public List<EducationDegree> getEducationDegrees() {
		return educationDegrees;
	}

	public void setEducationDegrees(List<EducationDegree> educationDegrees) {
		this.educationDegrees = educationDegrees;
	}
}
