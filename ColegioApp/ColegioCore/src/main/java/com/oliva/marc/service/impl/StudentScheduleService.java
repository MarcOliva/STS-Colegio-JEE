package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.StudentSchedule;
import com.oliva.marc.model.repository.IStudentScheduleRepository;
import com.oliva.marc.service.IStudentScheduleService;

@Named
public class StudentScheduleService implements IStudentScheduleService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IStudentScheduleRepository studentScheduleRepository;
	
	@Override
	@Transactional
	public Integer insert(StudentSchedule t) throws Exception {
		return studentScheduleRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(StudentSchedule t) throws Exception {
		return studentScheduleRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(StudentSchedule t) throws Exception {
		return studentScheduleRepository.delete(t);
	}

	@Override
	public List<StudentSchedule> findAll() throws Exception {
		return studentScheduleRepository.findAll();
	}

	@Override
	public StudentSchedule findById(StudentSchedule t) throws Exception {
		return studentScheduleRepository.findById(t);
	}
}
