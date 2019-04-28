package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.model.repository.IEmpoweredRepository;

public class EmpoweredRepository implements IEmpoweredRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Empowered t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Empowered t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Empowered t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Empowered> findAll() throws Exception {
		List<Empowered> empowereds = new ArrayList<>();

		TypedQuery<Empowered> query = em.createQuery("SELECT e FROM Empowered e", Empowered.class);
		empowereds = query.getResultList();
		return empowereds;
	}

	@Override
	public Empowered findById(Empowered t) throws Exception {
		List<Empowered> empowereds = new ArrayList<>();
		TypedQuery<Empowered> query = em.createQuery("SELECT e FROM Empowered e WHERE e.id = ?1", Empowered.class);
		query.setParameter(1, t.getId());

		empowereds = query.getResultList();

		return empowereds != null && !empowereds.isEmpty() ?empowereds.get(0) : new Empowered();
	}
}
