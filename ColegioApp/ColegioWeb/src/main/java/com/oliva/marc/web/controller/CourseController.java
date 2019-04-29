package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.service.impl.CourseService;

@Named
@ViewScoped
public class CourseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private CourseService courseService;
	private List<Course> courses;
	private Course courseSelec;
	private Course course;
	
	private EducationDegree gradeSelec;
	@PostConstruct
	public void init() {
		course = new Course();
		courseSelec = new Course();
	}
	public void loadCourses() {
		try {
			this.courses = courseService.findByGradeId(gradeSelec.getId());
			System.out.print(true);
		} catch (Exception e) {
			System.out.print(true);
		}
	}
	public void selectGrade(SelectEvent e) {
		this.gradeSelec = (EducationDegree) e.getObject();
		loadCourses();
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public EducationDegree getGradeSelec() {
		return gradeSelec;
	}
	public void setGradeSelec(EducationDegree gradeSelec) {
		this.gradeSelec = gradeSelec;
	}
	public Course getCourseSelec() {
		return courseSelec;
	}
	public void setCourseSelec(Course courseSelect) {
		this.courseSelec = courseSelect;
	}
	
}
