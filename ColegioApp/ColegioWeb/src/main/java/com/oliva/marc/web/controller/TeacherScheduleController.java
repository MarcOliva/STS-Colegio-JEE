package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.service.impl.EducationDegreeService;
import com.oliva.marc.service.impl.StudentService;
import com.oliva.marc.service.impl.TeacherScheduleService;

@Named
@ViewScoped
public class TeacherScheduleController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TeacherScheduleService teacherScheduleService;
	private List<TeacherSchedule> teacherSchedule;
	
	@Inject 
	private EducationDegreeService gradeService;
	private EducationDegree gradeSelec;
	private List<EducationDegree> grades;
	
	private List<Course> courses;
	
	@Inject
	private StudentService studentService;
	
	private List<Student> students;
	
	@PostConstruct
	public void init() {
		gradeSelec = new EducationDegree();
		
		loadTeacherSchedule();
	}
	public void loadTeacherSchedule() {
		try {
			this.grades = gradeService.findByTeacherId(1);
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.print(message);
		}
	}
	public void loadStudents() {
		try {
			cleanStudents();
			this.students = studentService.findByDegreeId(gradeSelec);
			gradeSelec = new EducationDegree();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void selectGrade(SelectEvent e) {
		this.gradeSelec = (EducationDegree) e.getObject();
		loadStudents();
	}
	public void cleanStudents() {
		this.students = null;
	}
	public List<EducationDegree> getGrades() {
		return grades;
	}
	public void setGrades(List<EducationDegree> grades) {
		this.grades = grades;
	}
	public List<TeacherSchedule> getTeacherSchedule() {
		return teacherSchedule;
	}
	public void setTeacherSchedule(List<TeacherSchedule> teacherSchedule) {
		this.teacherSchedule = teacherSchedule;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public EducationDegree getGradeSelec() {
		return gradeSelec;
	}
	public void setGradeSelec(EducationDegree gradeSelec) {
		this.gradeSelec = gradeSelec;
	}
	
	
}
