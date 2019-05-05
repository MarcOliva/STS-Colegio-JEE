package com.oliva.marc.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.oliva.marc.model.entity.Day;
import com.oliva.marc.service.impl.DayService;

@Named
@ViewScoped
public class DayController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DayService dayService;
	
	private Day day;
	private Day daySelec;
	private List<Day> days;
	
	@PostConstruct
	public void init() {
		day = new Day();
		daySelec = new Day();
		loadDays();
	}
	
	public void loadDays() {
		try {
			this.days = dayService.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveDay() {
		try {
			if (day.getId() != null) {
				dayService.update(day);
				System.out.println("Registro actualizado exitosamente");			
			} else {
				dayService.insert(day);
				System.out.println("Registro guardado exitosamente");
			}
			loadDays();
			clearForm();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void editDay() {
		try {
			if (this.daySelec != null) {
				this.day = daySelec;
			} else {
				System.out.println("Debe seleccionar un día");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectDay(SelectEvent e) {
		this.daySelec = (Day) e.getObject();
	}
	
	public void clearForm() {
		this.day = new Day();
		this.daySelec = null;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Day getDaySelec() {
		return daySelec;
	}

	public void setDaySelec(Day daySelec) {
		this.daySelec = daySelec;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
}
