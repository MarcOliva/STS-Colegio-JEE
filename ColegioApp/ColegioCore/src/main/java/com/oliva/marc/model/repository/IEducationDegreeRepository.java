package com.oliva.marc.model.repository;

import java.util.List;

import com.oliva.marc.model.entity.EducationDegree;

public interface IEducationDegreeRepository extends IJpaRepository<EducationDegree> {
	List<EducationDegree> findByTeacherId(int id) throws Exception;
}
