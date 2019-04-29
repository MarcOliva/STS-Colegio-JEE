package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Request;
import com.oliva.marc.model.repository.IRequestRepository;

@Named
public class RequestRepository implements IRequestRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Request t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Request t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Request t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Request> findAll() throws Exception {
		List<Request> requests = new ArrayList<>();

		TypedQuery<Request> query = em.createQuery("SELECT r FROM Request r", Request.class);
		requests = query.getResultList();
		return requests;
	}

	@Override
	public Request findById(Request t) throws Exception {
		List<Request> requests = new ArrayList<>();
		TypedQuery<Request> query = em.createQuery("SELECT r FROM Request r WHERE r.id = ?1", Request.class);
		query.setParameter(1, t.getId());

		requests = query.getResultList();

		return requests != null && !requests.isEmpty() ?requests.get(0) : new Request();
	}
}
