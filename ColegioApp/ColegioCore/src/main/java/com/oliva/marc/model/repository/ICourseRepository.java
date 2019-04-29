package com.oliva.marc.model.repository;

import java.util.List;

import com.oliva.marc.model.entity.Course;

public interface ICourseRepository extends IJpaRepository<Course> {
	List<Course> findByGradeId(int id) throws Exception;
}
