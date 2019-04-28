package com.oliva.marc.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

import com.oliva.marc.model.entity.Qualification;
import com.oliva.marc.model.repository.IQualificationRepository;
import com.oliva.marc.service.IQualificationService;

@Named
public class QualificationService implements IQualificationService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IQualificationRepository qualificationRepository;
	
	@Override
	@Transactional
	public Integer insert(Qualification t) throws Exception {
		return qualificationRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Qualification t) throws Exception {
		return qualificationRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Qualification t) throws Exception {
		return qualificationRepository.delete(t);
	}

	@Override
	public List<Qualification> findAll() throws Exception {
		return qualificationRepository.findAll();
	}

	@Override
	public Qualification findById(Qualification t) throws Exception {
		return qualificationRepository.findById(t);
	}
}
