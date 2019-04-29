package com.oliva.marc.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.repository.ICourseRepository;

@Named
public class CourseRepository implements ICourseRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "colegioPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Course t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Course t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Course t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Course> findAll() throws Exception {
		List<Course> courses = new ArrayList<>();

		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
		courses = query.getResultList();
		return courses;
	}

	@Override
	public Course findById(Course t) throws Exception {
		List<Course> courses = new ArrayList<>();
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE c.id = ?1", Course.class);
		query.setParameter(1, t.getId());

		courses = query.getResultList();

		return courses != null && !courses.isEmpty() ?courses.get(0) : new Course();
	}

	@Override
	public List<Course> findByGradeId(int id) throws Exception {
		List<Course> courses = new ArrayList<>();
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Courses c WHERE c.id in (SELECT DISTINCT course.id FROM TeacherSchedule WHERE educationDegree.id = ?1 )", Course.class);
		query.setParameter(1, id);
		courses = query.getResultList();
		return courses;
	}
}
