package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.service.impl.CourseService;

@Named
@ViewScoped
public class CourseController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CourseService courseService;
	
	private Course course;
	private Course courseSelec;
	private List<Course> courses;
	
	@PostConstruct
	public void init() {
		course = new Course();
		courseSelec = new Course();
		loadCourses();
	}
	
	public void  loadCourses() {
		try {
			this.courses = courseService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveCourse() {
		try {
			if (course.getId() != null) {
				courseService.update(course);
				System.out.println("Registro actualizado exitosamente");			
			} else {
				courseService.insert(course);
				System.out.println("Registro guardado exitosamente");
			}
			loadCourses();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editCourse() {
		try {
			if (this.courseSelec != null) {
				this.course = courseSelec;
			} else {
				System.out.println("Debe seleccionar un curso");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectCourse(SelectEvent e) {
		this.courseSelec = (Course) e.getObject();
	}
	
	public void clearForm() {
		this.course = new Course();
		this.courseSelec = null;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourseSelec() {
		return courseSelec;
	}

	public void setCourseSelec(Course courseSelec) {
		this.courseSelec = courseSelec;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
