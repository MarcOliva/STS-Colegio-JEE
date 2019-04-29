package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.StudentSchedule;
import com.oliva.marc.model.repository.IStudentScheduleRepository;

@Named
public class StudentScheduleRepository implements IStudentScheduleRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(StudentSchedule t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(StudentSchedule t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(StudentSchedule t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<StudentSchedule> findAll() throws Exception {
		List<StudentSchedule> studentSchedules = new ArrayList<>();

		TypedQuery<StudentSchedule> query = em.createQuery("SELECT s FROM StudentSchedule s", StudentSchedule.class);
		studentSchedules = query.getResultList();
		return studentSchedules;
	}

	@Override
	public StudentSchedule findById(StudentSchedule t) throws Exception {
		List<StudentSchedule> studentSchedules = new ArrayList<>();
		TypedQuery<StudentSchedule> query = em.createQuery("SELECT s FROM StudentSchedule s WHERE s.id = ?1", StudentSchedule.class);
		query.setParameter(1, t.getId());

		studentSchedules = query.getResultList();

		return studentSchedules != null && !studentSchedules.isEmpty() ?studentSchedules.get(0) : new StudentSchedule();
	}
}
