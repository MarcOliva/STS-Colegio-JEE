package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Request;
import com.oliva.marc.model.repository.IRequestRepository;
import com.oliva.marc.service.IRequestService;

@Named
public class RequestService implements IRequestService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IRequestRepository requestRepository;
	
	@Override
	@Transactional
	public Integer insert(Request t) throws Exception {
		return requestRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Request t) throws Exception {
		return requestRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Request t) throws Exception {
		return requestRepository.delete(t);
	}

	@Override
	public List<Request> findAll() throws Exception {
		return requestRepository.findAll();
	}

	@Override
	public Request findById(Request t) throws Exception {
		return requestRepository.findById(t);
	}
}
