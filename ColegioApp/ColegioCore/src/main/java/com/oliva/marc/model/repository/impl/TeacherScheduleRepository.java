package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.model.repository.ITeacherScheduleRepository;

@Named
public class TeacherScheduleRepository implements ITeacherScheduleRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(TeacherSchedule t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(TeacherSchedule t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(TeacherSchedule t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<TeacherSchedule> findAll() throws Exception {
		List<TeacherSchedule> teacherSchedules = new ArrayList<>();

		TypedQuery<TeacherSchedule> query = em.createQuery("SELECT t FROM TeacherSchedule t", TeacherSchedule.class);
		teacherSchedules = query.getResultList();
		return teacherSchedules;
	}

	@Override
	public TeacherSchedule findById(TeacherSchedule t) throws Exception {
		List<TeacherSchedule> teacherSchedules = new ArrayList<>();
		TypedQuery<TeacherSchedule> query = em.createQuery("SELECT t FROM TeacherSchedule t WHERE t.id = ?1", TeacherSchedule.class);
		query.setParameter(1, t.getId());

		teacherSchedules = query.getResultList();

		return teacherSchedules != null && !teacherSchedules.isEmpty() ?teacherSchedules.get(0) : new TeacherSchedule();
	}

	
}
