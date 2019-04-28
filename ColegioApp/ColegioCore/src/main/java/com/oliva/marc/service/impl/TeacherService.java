package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.model.repository.ITeacherRepository;
import com.oliva.marc.service.ITeacherService;

@Named
public class TeacherService implements ITeacherService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITeacherRepository teacherRepository;
	
	@Override
	@Transactional
	public Integer insert(Teacher t) throws Exception {
		return teacherRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Teacher t) throws Exception {
		return teacherRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Teacher t) throws Exception {
		return teacherRepository.delete(t);
	}

	@Override
	public List<Teacher> findAll() throws Exception {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findById(Teacher t) throws Exception {
		return teacherRepository.findById(t);
	}
}
