package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.repository.IEducationDegreeRepository;
import com.oliva.marc.service.IEducationDegreeService;

@Named
public class EducationDegreeService implements IEducationDegreeService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEducationDegreeRepository educationDegreeRepository;
	
	@Override
	@Transactional
	public Integer insert(EducationDegree t) throws Exception {
		return educationDegreeRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(EducationDegree t) throws Exception {
		return educationDegreeRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(EducationDegree t) throws Exception {
		return educationDegreeRepository.delete(t);
	}

	@Override
	public List<EducationDegree> findAll() throws Exception {
		return educationDegreeRepository.findAll();
	}

	@Override
	public EducationDegree findById(EducationDegree t) throws Exception {
		return educationDegreeRepository.findById(t);
	}
}
