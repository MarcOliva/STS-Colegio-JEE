package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.EducationLevel;
import com.oliva.marc.model.repository.IEducationLevelRepository;
import com.oliva.marc.service.IEducationLevelService;

@Named
public class EducationLevelService implements IEducationLevelService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEducationLevelRepository educationLevelRepository;
	
	@Override
	@Transactional
	public Integer insert(EducationLevel t) throws Exception {
		return educationLevelRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(EducationLevel t) throws Exception {
		return educationLevelRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(EducationLevel t) throws Exception {
		return educationLevelRepository.delete(t);
	}

	@Override
	public List<EducationLevel> findAll() throws Exception {
		return educationLevelRepository.findAll();
	}

	@Override
	public EducationLevel findById(EducationLevel t) throws Exception {
		return educationLevelRepository.findById(t);
	}
}
