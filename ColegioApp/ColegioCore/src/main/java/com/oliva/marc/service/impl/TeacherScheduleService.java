package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.model.repository.ITeacherScheduleRepository;
import com.oliva.marc.service.ITeacherScheduleService;

@Named
public class TeacherScheduleService implements ITeacherScheduleService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITeacherScheduleRepository teacherScheduleRepository;
	
	@Override
	@Transactional
	public Integer insert(TeacherSchedule t) throws Exception {
		return teacherScheduleRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(TeacherSchedule t) throws Exception {
		return teacherScheduleRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(TeacherSchedule t) throws Exception {
		return teacherScheduleRepository.delete(t);
	}

	@Override
	public List<TeacherSchedule> findAll() throws Exception {
		return teacherScheduleRepository.findAll();
	}

	@Override
	public TeacherSchedule findById(TeacherSchedule t) throws Exception {
		return teacherScheduleRepository.findById(t);
	}

}
