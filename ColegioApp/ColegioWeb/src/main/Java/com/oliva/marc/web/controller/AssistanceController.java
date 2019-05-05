package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Assistance;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.service.impl.AssistanceService;
import com.oliva.marc.service.impl.StudentService;
import com.oliva.marc.service.impl.TeacherScheduleService;

@Named
@ViewScoped
public class AssistanceController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AssistanceService assistanceService;
	
	@Inject
	private StudentService studentService;
	
	@Inject
	private TeacherScheduleService teacherScheduleService;
	
	private Assistance assistance;
	private Assistance assistanceSelec;
	private List<Assistance> assistances;
	
	private Student student;
	private List<Student> students;
	
	private TeacherSchedule teacherSchedule;
	private List<TeacherSchedule> teacherSchedules;
	
	@PostConstruct
	public void init() {
		assistance = new Assistance();
		assistanceSelec = new Assistance();
		loadAssistances();
		loadStudents();
		loadTeacherSchedules();
	}
	
	public void loadAssistances() {
		try {
			this.assistances = assistanceService.findAll();
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
	
	public void loadTeacherSchedules() {
		try {
			this.teacherSchedules = teacherScheduleService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveAssistance() {
		try {
			if (assistance.getId() != null) {
				assistance.setStudent(student);
				assistance.setTeacherSchedule(teacherSchedule);
				assistanceService.update(assistance);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				assistance.setStudent(student);
				assistance.setTeacherSchedule(teacherSchedule);
				assistanceService.insert(assistance);
				System.out.println("Registro guardado exitosamente");
			}
			loadAssistances();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editAssistance() {
		try {
			if (this.assistanceSelec != null) {
				this.assistance = assistanceSelec;
			} else {
				System.out.println("Debe seleccionar una asistencia");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectAssistance(SelectEvent e) {
		this.assistanceSelec = (Assistance) e.getObject();
	}
	
	public void clearForm() {
		this.assistance = new Assistance();
		this.assistanceSelec = null;
	}

	public Assistance getAssistance() {
		return assistance;
	}

	public void setAssistance(Assistance assistance) {
		this.assistance = assistance;
	}

	public Assistance getAssistanceSelec() {
		return assistanceSelec;
	}

	public void setAssistanceSelec(Assistance assistanceSelec) {
		this.assistanceSelec = assistanceSelec;
	}

	public List<Assistance> getAssistances() {
		return assistances;
	}

	public void setAssistances(List<Assistance> assistances) {
		this.assistances = assistances;
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

	public TeacherSchedule getTeacherSchedule() {
		return teacherSchedule;
	}

	public void setTeacherSchedule(TeacherSchedule teacherSchedule) {
		this.teacherSchedule = teacherSchedule;
	}

	public List<TeacherSchedule> getTeacherSchedules() {
		return teacherSchedules;
	}

	public void setTeacherSchedules(List<TeacherSchedule> teacherSchedules) {
		this.teacherSchedules = teacherSchedules;
	}
}
