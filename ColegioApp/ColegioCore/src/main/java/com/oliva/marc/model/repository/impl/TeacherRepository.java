package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.model.repository.ITeacherRepository;

@Named
public class TeacherRepository implements ITeacherRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Teacher t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Teacher t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Teacher t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Teacher> findAll() throws Exception {
		List<Teacher> teachers = new ArrayList<>();

		TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
		teachers = query.getResultList();
		return teachers;
	}

	@Override
	public Teacher findById(Teacher t) throws Exception {
		List<Teacher> teachers = new ArrayList<>();
		TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE t.id = ?1", Teacher.class);
		query.setParameter(1, t.getId());

		teachers = query.getResultList();

		return teachers != null && !teachers.isEmpty() ?teachers.get(0) : new Teacher();
	}
}
