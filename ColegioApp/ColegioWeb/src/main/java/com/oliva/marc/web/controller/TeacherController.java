package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.EducationLevel;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.service.impl.EducationDegreeService;
import com.oliva.marc.service.impl.EducationLevelService;
import com.oliva.marc.service.impl.TeacherService;

@Named
@ViewScoped
public class TeacherController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TeacherService teacherService;	
	private Teacher teacher;
	

	@Inject
	private EducationDegreeService educationDegreeService;
	private EducationDegree educationDegree;
	
	private List<EducationDegree> grades;
	
	@PostConstruct
	public void init() {
		teacher = new Teacher();
		loadGrades();
	}
	public void loadGrades() {
		try {
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
