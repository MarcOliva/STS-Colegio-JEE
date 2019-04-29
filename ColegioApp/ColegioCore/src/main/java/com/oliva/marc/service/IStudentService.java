package com.oliva.marc.service;

import java.util.List;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Student;

public interface IStudentService extends ICrudService<Student> {
	List<Student> findByDegreeId(EducationDegree t) throws Exception;
}
