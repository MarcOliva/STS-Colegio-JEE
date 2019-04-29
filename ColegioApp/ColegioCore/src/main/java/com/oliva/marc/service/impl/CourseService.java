package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.repository.ICourseRepository;
import com.oliva.marc.service.ICourseService;

@Named
public class CourseService implements ICourseService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICourseRepository courseRepository;
	
	@Override
	@Transactional
	public Integer insert(Course t) throws Exception {
		return courseRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Course t) throws Exception {
		return courseRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Course t) throws Exception {
		return courseRepository.delete(t);
	}

	@Override
	public List<Course> findAll() throws Exception {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(Course t) throws Exception {
		return courseRepository.findById(t);
	}

	@Override
	public List<Course> findByGradeId(int id) throws Exception {
		return courseRepository.findByGradeId(id);
	}
}
