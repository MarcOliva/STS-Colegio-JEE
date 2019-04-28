package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.EducationLevel;
import com.oliva.marc.model.repository.IEducationLevelRepository;

@Named
public class EducationLevelRepository implements IEducationLevelRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(EducationLevel t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(EducationLevel t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(EducationLevel t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<EducationLevel> findAll() throws Exception {
		List<EducationLevel> educationLevels = new ArrayList<>();

		TypedQuery<EducationLevel> query = em.createQuery("SELECT e FROM EducationLevel e", EducationLevel.class);
		educationLevels = query.getResultList();
		return educationLevels;
	}

	@Override
	public EducationLevel findById(EducationLevel t) throws Exception {
		List<EducationLevel> educationLevels = new ArrayList<>();
		TypedQuery<EducationLevel> query = em.createQuery("SELECT e FROM EducationLevel e WHERE e.id = ?1", EducationLevel.class);
		query.setParameter(1, t.getId());

		educationLevels = query.getResultList();

		return educationLevels != null && !educationLevels.isEmpty() ?educationLevels.get(0) : new EducationLevel();
	}
}
