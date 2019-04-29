package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Assistance;
import com.oliva.marc.model.repository.IAssistanceRepository;
import com.oliva.marc.service.IAssistanceService;

@Named
public class AssistanceService implements IAssistanceService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAssistanceRepository assistanceRepository;
	
	@Override
	@Transactional
	public Integer insert(Assistance t) throws Exception {
		return assistanceRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Assistance t) throws Exception {
		return assistanceRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Assistance t) throws Exception {
		return assistanceRepository.delete(t);
	}

	@Override
	public List<Assistance> findAll() throws Exception {
		return assistanceRepository.findAll();
	}

	@Override
	public Assistance findById(Assistance t) throws Exception {
		return assistanceRepository.findById(t);
	}
}
