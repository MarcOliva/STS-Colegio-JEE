package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Day;
import com.oliva.marc.model.repository.IDayRepository;
import com.oliva.marc.service.IDayService;

@Named
public class DayService implements IDayService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDayRepository dayRepository;
	
	@Override
	@Transactional
	public Integer insert(Day t) throws Exception {
		return dayRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Day t) throws Exception {
		return dayRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Day t) throws Exception {
		return dayRepository.delete(t);
	}

	@Override
	public List<Day> findAll() throws Exception {
		return dayRepository.findAll();
	}

	@Override
	public Day findById(Day t) throws Exception {
		return dayRepository.findById(t);
	}
}
