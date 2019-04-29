package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Qualification;
import com.oliva.marc.model.repository.IQualificationRepository;

@Named
public class QualificationRepository implements IQualificationRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Qualification t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Qualification t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Qualification t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Qualification> findAll() throws Exception {
		List<Qualification> qualifications = new ArrayList<>();

		TypedQuery<Qualification> query = em.createQuery("SELECT q FROM Qualification q", Qualification.class);
		qualifications = query.getResultList();
		return qualifications;
	}

	@Override
	public Qualification findById(Qualification t) throws Exception {
		List<Qualification> qualifications = new ArrayList<>();
		TypedQuery<Qualification> query = em.createQuery("SELECT q FROM Qualification q WHERE q.id = ?1", Qualification.class);
		query.setParameter(1, t.getId());

		qualifications = query.getResultList();

		return qualifications != null && !qualifications.isEmpty() ?qualifications.get(0) : new Qualification();
	}
}
