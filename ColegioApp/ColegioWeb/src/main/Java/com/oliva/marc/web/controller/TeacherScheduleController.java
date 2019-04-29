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
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.service.impl.CourseService;
import com.oliva.marc.service.impl.DayService;
import com.oliva.marc.service.impl.EducationDegreeService;
import com.oliva.marc.service.impl.TeacherScheduleService;
import com.oliva.marc.service.impl.TeacherService;

@Named
@ViewScoped
public class TeacherScheduleController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TeacherScheduleService teacherScheduleService;
	
	@Inject
	private DayService dayService;
	
	@Inject
	private CourseService courseService;
	
	@Inject
	private EducationDegreeService educationDegreeService;
	
	@Inject
	private TeacherService teacherService;
	
	private TeacherSchedule teacherSchedule;
	private TeacherSchedule teacherScheduleSelec;
	private List<TeacherSchedule> teacherSchedules;
	
	private Day day;
	private List<Day> days;
	
	private Course course;
	private List<Course> courses;
	
	private EducationDegree educationDegree;
	private List<EducationDegree> educationDegrees;
	
	private Teacher teacher;
	private List<Teacher> teachers;
	
	@PostConstruct
	public void init() {
		teacherSchedule = new TeacherSchedule();
		teacherScheduleSelec = new TeacherSchedule();
		loadTeacherSchedules();
		loadDays();
		loadCourses();
		loadEducationDegrees();
		loadTeachers();
	}
	
	public void loadTeacherSchedules() {
		try {
			this.teacherSchedules = teacherScheduleService.findAll();
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
	
	public void loadEducationDegrees() {
		try {
			this.educationDegrees= educationDegreeService.findAll();
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
	
	public void saveTeacherSchedule() {
		try {
			if (teacherSchedule.getId() != null) {
				teacherSchedule.setDay(day);
				teacherSchedule.setCourse(course);
				teacherSchedule.setEducationDegree(educationDegree);
				teacherSchedule.setTeacher(teacher);
				teacherScheduleService.update(teacherSchedule);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				teacherSchedule.setDay(day);
				teacherSchedule.setCourse(course);
				teacherSchedule.setEducationDegree(educationDegree);
				teacherSchedule.setTeacher(teacher);
				teacherScheduleService.insert(teacherSchedule);
				System.out.println("Registro guardado exitosamente");
			}
			loadTeacherSchedules();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editTeacherSchedule() {
		try {
			if (this.teacherScheduleSelec != null) {
				this.teacherSchedule = teacherScheduleSelec;
			} else {
				System.out.println("Debe seleccionar un horario de profesor");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectTeacherSchedule(SelectEvent e) {
		this.teacherScheduleSelec = (TeacherSchedule) e.getObject();
	}
	
	public void clearForm() {
		this.teacherSchedule = new TeacherSchedule();
		this.teacherScheduleSelec = null;
	}

	public TeacherSchedule getTeacherSchedule() {
		return teacherSchedule;
	}

	public void setTeacherSchedule(TeacherSchedule teacherSchedule) {
		this.teacherSchedule = teacherSchedule;
	}

	public TeacherSchedule getTeacherScheduleSelec() {
		return teacherScheduleSelec;
	}

	public void setTeacherScheduleSelec(TeacherSchedule teacherScheduleSelec) {
		this.teacherScheduleSelec = teacherScheduleSelec;
	}

	public List<TeacherSchedule> getTeacherSchedules() {
		return teacherSchedules;
	}

	public void setTeacherSchedules(List<TeacherSchedule> teacherSchedules) {
		this.teacherSchedules = teacherSchedules;
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
}
