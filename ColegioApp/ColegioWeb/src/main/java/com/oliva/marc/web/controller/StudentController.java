package com.oliva.marc.web.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.service.impl.StudentService;

@Named
@ViewScoped
public class StudentController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private StudentService studentService;
	private Student student;
	private List<Student> students;
	
	private EducationDegree educationDegree;
	
	@PostConstruct
	public void init() {
		student = new Student();
		educationDegree = new EducationDegree();
	}
	public void loadStudents() {
		try {
			students = studentService.findByDegreeId(educationDegree);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public EducationDegree getEducationDegree() {
		return educationDegree;
	}
	public void setEducationDegree(EducationDegree educationDegree) {
		this.educationDegree = educationDegree;
	}
	
	
}
