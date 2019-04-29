package com.oliva.marc.model.repository;

import java.util.List;

import com.oliva.marc.model.entity.EducationDegree;

public interface IJpaRepository<T> {

	Integer insert(T t) throws Exception;

	Integer update(T t) throws Exception;

	Integer delete(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(T t) throws Exception;

}
