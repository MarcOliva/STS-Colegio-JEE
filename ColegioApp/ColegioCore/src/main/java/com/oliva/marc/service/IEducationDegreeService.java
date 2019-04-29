package com.oliva.marc.service;

import java.util.List;

import com.oliva.marc.model.entity.EducationDegree;

public interface IEducationDegreeService extends ICrudService<EducationDegree> {
	List<EducationDegree> findByTeacherId(int id) throws Exception;
}
