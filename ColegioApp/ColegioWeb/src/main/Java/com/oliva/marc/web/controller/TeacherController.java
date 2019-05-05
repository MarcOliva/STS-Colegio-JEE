package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.service.impl.EducationDegreeService;
import com.oliva.marc.service.impl.TeacherService;

@Named
@ViewScoped
public class TeacherController implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private TeacherService teacherService;
	
	@Inject
	private EducationDegreeService educationDegreeService;
	
	private Teacher teacher;
	private Teacher teacherSelec;
	private List<Teacher> teachers;
	
	private EducationDegree educationDegree;
	private List<EducationDegree> educationDegrees;
	
	@PostConstruct
	public void init() {
		teacher = new Teacher();
		teacherSelec = new Teacher();
		loadTeachers();
		loadEducationDegrees();
	}
	
	public void loadTeachers() {
		try {
			this.teachers = teacherService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadEducationDegrees() {
		try {
			this.educationDegrees = educationDegreeService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveTeacher() {
		try {
			if (teacher.getId() != null) {
				teacher.setEducationDegree(educationDegree);
				teacherService.update(teacher);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				teacher.setEducationDegree(educationDegree);
				teacherService.insert(teacher);
				System.out.println("Registro guardado exitosamente");
			}
			loadTeachers();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editTeacher() {
		try {
			if (this.teacherSelec != null) {
				this.teacher = teacherSelec;
			} else {
				System.out.println("Debe seleccionar profesor");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectTeacher(SelectEvent e) {
		this.teacherSelec = (Teacher) e.getObject();
	}
	
	public void clearForm() {
		this.teacher = new Teacher();
		this.teacherSelec = null;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacherSelec() {
		return teacherSelec;
	}

	public void setTeacherSelec(Teacher teacherSelec) {
		this.teacherSelec = teacherSelec;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public EducationDegree getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(EducationDegree educationDegree) {
		this.educationDegree = educationDegree;
	}

	public List<EducationDegree> getEducationDegrees() {
		return educationDegrees;
	}

	public void setEducationDegrees(List<EducationDegree> educationDegrees) {
		this.educationDegrees = educationDegrees;
	}
}
