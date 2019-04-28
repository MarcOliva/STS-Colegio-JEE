package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Day;
import com.oliva.marc.model.repository.IDayRepository;

@Named
public class DayRepository implements IDayRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Day t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Day t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Day t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Day> findAll() throws Exception {
		List<Day> days = new ArrayList<>();

		TypedQuery<Day> query = em.createQuery("SELECT d FROM Day d", Day.class);
		days = query.getResultList();
		return days;
	}

	@Override
	public Day findById(Day t) throws Exception {
		List<Day> days = new ArrayList<>();
		TypedQuery<Day> query = em.createQuery("SELECT d FROM Day d WHERE d.id = ?1", Day.class);
		query.setParameter(1, t.getId());

		days = query.getResultList();

		return days != null && !days.isEmpty() ?days.get(0) : new Day();
	}
}
