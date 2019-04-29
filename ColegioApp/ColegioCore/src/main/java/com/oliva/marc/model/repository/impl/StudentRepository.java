package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.model.repository.IStudentRepository;

@Named
public class StudentRepository implements IStudentRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;

	@Override
	public Integer insert(Student t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Student t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Student t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Student> findAll() throws Exception {
		List<Student> students = new ArrayList<>();

		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
		students = query.getResultList();
		return students;
	}

	@Override
	public Student findById(Student t) throws Exception {
		List<Student> students = new ArrayList<>();
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.id = ?1", Student.class);
		query.setParameter(1, t.getId());

		students = query.getResultList();

		return students != null && !students.isEmpty() ? students.get(0) : new Student();
	}

	@Override
	public List<Student> findByDegreeId(EducationDegree t) throws Exception {
		List<Student> students = new ArrayList<>();
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.educationDegree.id = ?1", Student.class);
		query.setParameter(1, t.getId());	
		students = query.getResultList();
		return students;
	}
}
