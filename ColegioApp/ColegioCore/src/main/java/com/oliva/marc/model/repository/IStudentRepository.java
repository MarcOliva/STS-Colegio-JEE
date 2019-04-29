package com.oliva.marc.model.repository;

import java.util.List;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Student;

public interface IStudentRepository extends IJpaRepository<Student> {
	
	List<Student> findByDegreeId(EducationDegree t) throws Exception;
}
