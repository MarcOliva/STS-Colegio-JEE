package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.model.repository.IEmpoweredRepository;
import com.oliva.marc.service.IEmpoweredService;

@Named
public class EmpoweredService implements IEmpoweredService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEmpoweredRepository empoweredRepository;
	
	@Override
	@Transactional
	public Integer insert(Empowered t) throws Exception {
		return empoweredRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Empowered t) throws Exception {
		return empoweredRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Empowered t) throws Exception {
		return empoweredRepository.delete(t);
	}

	@Override
	public List<Empowered> findAll() throws Exception {
		return empoweredRepository.findAll();
	}

	@Override
	public Empowered findById(Empowered t) throws Exception {
		return empoweredRepository.findById(t);
	}
}
