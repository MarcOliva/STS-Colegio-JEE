package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.service.impl.EducationDegreeService;
import com.oliva.marc.service.impl.EmpoweredService;
import com.oliva.marc.service.impl.StudentService;

@Named
@ViewScoped
public class StudentController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private StudentService studentService;
	
	@Inject
	private EmpoweredService empoweredService;
	
	@Inject
	private EducationDegreeService educationDegreeService;
	
	private Student student;
	private Student studentSelec;
	private List<Student> students;
	
	private Empowered empowered;
	private List<Empowered> empowereds;
	
	private EducationDegree educationDegree;
	private List<EducationDegree> educationDegrees;
	
	@PostConstruct
	public void init() {
		student = new Student();
		studentSelec = new Student();
		loadStudents();
		loadEmpowereds();
		loadEducationDegrees();
	}
	
	public void loadStudents() {
		try {
			this.students = studentService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadEmpowereds() {
		try {
			this.empowereds = empoweredService.findAll();
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
	
	public void saveStudent() {
		try {
			if (student.getId() != null) {
				student.setEmpowered(empowered);
				student.setEducationDegree(educationDegree);
				studentService.update(student);
				System.out.println("Registro actualizado exitosamente");		
			} else {
				student.setEmpowered(empowered);
				student.setEducationDegree(educationDegree);
				studentService.insert(student);
				System.out.println("Registro guardado exitosamente");
			}
			loadStudents();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editStudent() {
		try {
			if (this.studentSelec != null) {
				this.student = studentSelec;
			} else {
				System.out.println("Debe seleccionar un alumno");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectStudent(SelectEvent e) {
		this.studentSelec = (Student) e.getObject();
	}
	
	public void clearForm() {
		this.student = new Student();
		this.studentSelec = null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudentSelec() {
		return studentSelec;
	}

	public void setStudentSelec(Student studentSelec) {
		this.studentSelec = studentSelec;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Empowered getEmpowered() {
		return empowered;
	}

	public void setEmpowered(Empowered empowered) {
		this.empowered = empowered;
	}

	public List<Empowered> getEmpowereds() {
		return empowereds;
	}

	public void setEmpowereds(List<Empowered> empowereds) {
		this.empowereds = empowereds;
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
