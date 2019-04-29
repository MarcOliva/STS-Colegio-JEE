package com.oliva.marc.service;

import java.util.List;

import com.oliva.marc.model.entity.Course;

public interface ICourseService extends ICrudService<Course> {
	List<Course> findByGradeId(int id) throws Exception;
}
