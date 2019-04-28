package com.oliva.marc.service;

import java.util.List;

public interface ICrudService<T> {
	
	Integer insert(T t) throws Exception;

	Integer update(T t) throws Exception;

	Integer delete(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(T t) throws Exception;
}
