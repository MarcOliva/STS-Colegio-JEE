package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.Qualification;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.service.impl.CourseService;
import com.oliva.marc.service.impl.QualificationService;
import com.oliva.marc.service.impl.StudentService;
import com.oliva.marc.service.impl.TeacherService;

@Named
@ViewScoped
public class QualificationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private QualificationService qualificationService;
	
	@Inject
	private CourseService courseService;
	
	@Inject
	private TeacherService teacherService;
	
	@Inject
	private StudentService studentService;
	
	private Qualification qualification;
	private Qualification qualificationSelec;
	private List<Qualification> qualifications;
	
	private Course course;
	private List<Course> courses;
	
	private Teacher teacher;
	private List<Teacher> teachers;
	
	private Student student;
	private List<Student> students;
	
	@PostConstruct
	public void init() {
		qualification = new Qualification();
		qualificationSelec = new Qualification();
		loadQualifications();
		loadCourses();
		loadTeachers();
		loadStudents();
	}
	
	public void loadQualifications() {
		try {
			this.qualifications = qualificationService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadCourses() {
		try {
			this.courses = courseService.findAll();
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
	
	public void loadStudents() {
		try {
			this.students = studentService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveQualification() {
		try {
			if (qualification.getId() != null) {
				qualification.setCourse(course);
				qualification.setTeacher(teacher);
				qualification.setStudent(student);
				qualificationService.update(qualification);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				qualification.setCourse(course);
				qualification.setTeacher(teacher);
				qualification.setStudent(student);
				qualificationService.insert(qualification);
				System.out.println("Registro guardado exitosamente");
			}
			loadQualifications();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editQualification() {
		try {
			if (this.qualificationSelec != null) {
				this.qualification = qualificationSelec;
			} else {
				System.out.println("Debe seleccionar una calificación");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectQualification(SelectEvent e) {
		this.qualificationSelec = (Qualification) e.getObject();
	}
	
	public void clearForm() {
		this.qualification = new Qualification();
		this.qualificationSelec = null;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Qualification getQualificationSelec() {
		return qualificationSelec;
	}

	public void setQualificationSelec(Qualification qualificationSelec) {
		this.qualificationSelec = qualificationSelec;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
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
}
