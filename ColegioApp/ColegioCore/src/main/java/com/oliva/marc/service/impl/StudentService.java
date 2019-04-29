package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.repository.IStudentRepository;
import com.oliva.marc.service.IStudentService;

@Named
public class StudentService implements IStudentService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IStudentRepository studentRepository;
	
	@Override
	@Transactional
	public Integer insert(Student t) throws Exception {
		return studentRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Student t) throws Exception {
		return studentRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Student t) throws Exception {
		return studentRepository.delete(t);
	}

	@Override
	public List<Student> findAll() throws Exception {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Student t) throws Exception {
		return studentRepository.findById(t);
	}
}
