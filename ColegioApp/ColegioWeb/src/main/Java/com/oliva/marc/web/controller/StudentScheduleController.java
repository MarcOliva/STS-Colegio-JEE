package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.Day;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.entity.StudentSchedule;
import com.oliva.marc.service.impl.CourseService;
import com.oliva.marc.service.impl.DayService;
import com.oliva.marc.service.impl.StudentScheduleService;
import com.oliva.marc.service.impl.StudentService;

@Named
@ViewScoped
public class StudentScheduleController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private StudentScheduleService studentScheduleService;
	
	@Inject
	private DayService dayService;
	
	@Inject
	private CourseService courseService;
	
	@Inject
	private StudentService studentService;
	
	private StudentSchedule studentSchedule;
	private StudentSchedule studentScheduleSelec;
	private List<StudentSchedule> studentSchedules;
	
	private Day day;
	private List<Day> days;
	
	private Course course;
	private List<Course> courses;
	
	private Student student;
	private List<Student> students;
	
	@PostConstruct
	public void init() {
		studentSchedule = new StudentSchedule();
		studentScheduleSelec = new StudentSchedule();
		loadStudentSchedules();
		loadDays();
		loadCourses();
		loadStudents();
	}
	
	public void loadStudentSchedules() {
		try {
			this.studentSchedules = studentScheduleService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadDays() {
		try {
			this.days = dayService.findAll();
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
	
	public void loadStudents() {
		try {
			this.students = studentService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveStudentSchedule() {
		try {
			if (studentSchedule.getId() != null) {
				studentSchedule.setDay(day);
				studentSchedule.setCourse(course);
				studentSchedule.setStudent(student);
				studentScheduleService.update(studentSchedule);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				studentSchedule.setDay(day);
				studentSchedule.setCourse(course);
				studentSchedule.setStudent(student);
				studentScheduleService.insert(studentSchedule);
				System.out.println("Registro guardado exitosamente");
			}
			loadStudentSchedules();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editStudentSchedule() {
		try {
			if (this.studentScheduleSelec != null) {
				this.studentSchedule = studentScheduleSelec;
			} else {
				System.out.println("Debe seleccionar un horario de alumno");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectStudentSchedule(SelectEvent e) {
		this.studentScheduleSelec = (StudentSchedule) e.getObject();
	}
	
	public void clearForm() {
		this.studentSchedule = new StudentSchedule();
		this.studentScheduleSelec = null;
	}

	public StudentSchedule getStudentSchedule() {
		return studentSchedule;
	}

	public void setStudentSchedule(StudentSchedule studentSchedule) {
		this.studentSchedule = studentSchedule;
	}

	public StudentSchedule getStudentScheduleSelec() {
		return studentScheduleSelec;
	}

	public void setStudentScheduleSelec(StudentSchedule studentScheduleSelec) {
		this.studentScheduleSelec = studentScheduleSelec;
	}

	public List<StudentSchedule> getStudentSchedules() {
		return studentSchedules;
	}

	public void setStudentSchedules(List<StudentSchedule> studentSchedules) {
		this.studentSchedules = studentSchedules;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
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
