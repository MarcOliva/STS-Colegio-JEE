package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.repository.IEducationDegreeRepository;

@Named
public class EducationDegreeRepository implements IEducationDegreeRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(EducationDegree t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(EducationDegree t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(EducationDegree t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<EducationDegree> findAll() throws Exception {
		List<EducationDegree> educationDegrees = new ArrayList<>();

		TypedQuery<EducationDegree> query = em.createQuery("SELECT e FROM EducationDegree e", EducationDegree.class);
		educationDegrees = query.getResultList();
		return educationDegrees;
	}

	@Override
	public EducationDegree findById(EducationDegree t) throws Exception {
		List<EducationDegree> educationDegrees = new ArrayList<>();
		TypedQuery<EducationDegree> query = em.createQuery("SELECT e FROM EducationDegree e WHERE e.id = ?1", EducationDegree.class);
		query.setParameter(1, t.getId());

		educationDegrees = query.getResultList();

		return educationDegrees != null && !educationDegrees.isEmpty() ?educationDegrees.get(0) : new EducationDegree();
	}
	@Override
	public List<EducationDegree> findByTeacherId(int id) throws Exception {
		List<EducationDegree> grades = new ArrayList<>();
		TypedQuery<EducationDegree> query = em.createQuery("SELECT g FROM EducationDegree g WHERE g.id in (SELECT DISTINCT educationDegree.id FROM TeacherSchedule WHERE teacher.id = ?1 )", EducationDegree.class);
		query.setParameter(1, id);
		grades = query.getResultList();
		return grades;
	}
}
