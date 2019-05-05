package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.model.entity.Request;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.service.impl.EmpoweredService;
import com.oliva.marc.service.impl.RequestService;
import com.oliva.marc.service.impl.TeacherService;

@Named
@ViewScoped
public class RequestController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RequestService requestService;
	
	@Inject
	private TeacherService teacherService;
	
	@Inject
	private EmpoweredService empoweredService;
	
	private Request request;
	private Request requestSelec;
	private List<Request> requests;
	
	private Teacher teacher;
	private List<Teacher> teachers;
	
	private Empowered empowered;
	private List<Empowered> empowereds;
	
	@PostConstruct
	public void init() {
		request = new Request();
		requestSelec = new Request();
		loadRequests();
		loadTeachers();
		loadEmpowereds();
	}
	
	public void loadRequests() {
		try {
			this.requests = requestService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadTeachers() {
		try {
			this.teachers = teacherService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadEmpowereds() {
		try {
			this.empowereds = empoweredService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void saveStudent() {
		try {
			if (request.getId() != null) {
				request.setTeacher(teacher);
				request.setEmpowered(empowered);
				requestService.update(request);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				request.setTeacher(teacher);
				request.setEmpowered(empowered);
				requestService.insert(request);
				System.out.println("Registro guardado exitosamente");
			}
			loadRequests();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editRequest() {
		try {
			if (this.requestSelec != null) {
				this.request = requestSelec;
			} else {
				System.out.println("Debe seleccionar una solicitud");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectRequest(SelectEvent e) {
		this.requestSelec = (Request) e.getObject();
	}
	
	public void clearForm() {
		this.request = new Request();
		this.requestSelec = null;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Request getRequestSelec() {
		return requestSelec;
	}

	public void setRequestSelec(Request requestSelec) {
		this.requestSelec = requestSelec;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Empowered getEmpowered() {
		return empowered;
	}

	public void setEmpowered(Empowered empowered) {
		this.empowered = empowered;
	}

	public List<Empowered> getEmpowereds() {
		return empowereds;
	}

	public void setEmpowereds(List<Empowered> empowereds) {
		this.empowereds = empowereds;
	}
}
