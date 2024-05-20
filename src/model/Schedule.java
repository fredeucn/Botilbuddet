package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Schedule {
	private ArrayList<Period> periods;
	private String name;
	private LocalDate date;
	private String description;
	
	
	public Schedule(String name, String description) {
		periods = new ArrayList<>();
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPeriod(Period period) {
		periods.add(period);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
