package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.service.impl.EmpoweredService;

@Named
@ViewScoped
public class EmpoweredController implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpoweredService empoweredService;
	
	private Empowered empowered;
	private Empowered empoweredSelec;
	private List<Empowered> empowereds;
	
	@PostConstruct
	public void init() {
		empowered = new Empowered();
		empoweredSelec = new Empowered();
		loadEmpowereds();
	}
	
	public void loadEmpowereds() {
		try {
			this.empowereds = empoweredService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveEmpowered() {
		try {
			if (empowered.getId() != null) {
				empoweredService.update(empowered);
				System.out.println("Registro actualizado exitosamente");			
			} else {
				empoweredService.insert(empowered);
				System.out.println("Registro guardado exitosamente");
			}
			loadEmpowereds();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editEmpowered() {
		try {
			if (this.empoweredSelec != null) {
				this.empowered = empoweredSelec;
			} else {
				System.out.println("Debe seleccionar un apoderado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectEmpowered(SelectEvent e) {
		this.empoweredSelec = (Empowered) e.getObject();
	}
	
	public void clearForm() {
		this.empowered = new Empowered();
		this.empoweredSelec = null;
	}

	public Empowered getEmpowered() {
		return empowered;
	}

	public void setEmpowered(Empowered empowered) {
		this.empowered = empowered;
	}

	public Empowered getEmpoweredSelec() {
		return empoweredSelec;
	}

	public void setEmpoweredSelec(Empowered empoweredSelec) {
		this.empoweredSelec = empoweredSelec;
	}

	public List<Empowered> getEmpowereds() {
		return empowereds;
	}

	public void setEmpowereds(List<Empowered> empowereds) {
		this.empowereds = empowereds;
	}
}
