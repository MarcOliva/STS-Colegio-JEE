package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Assistance;
import com.oliva.marc.model.repository.IAssistanceRepository;

@Named
public class AssistanceRepository implements IAssistanceRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Assistance t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Assistance t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Assistance t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Assistance> findAll() throws Exception {
		List<Assistance> assistances = new ArrayList<>();

		TypedQuery<Assistance> query = em.createQuery("SELECT a FROM Assistance a", Assistance.class);
		assistances = query.getResultList();
		return assistances;
	}

	@Override
	public Assistance findById(Assistance t) throws Exception {
		List<Assistance> assistances = new ArrayList<>();
		TypedQuery<Assistance> query = em.createQuery("SELECT a FROM Assistance a WHERE a.id = ?1", Assistance.class);
		query.setParameter(1, t.getId());

		assistances = query.getResultList();

		return assistances != null && !assistances.isEmpty() ?assistances.get(0) : new Assistance();
	}
}
