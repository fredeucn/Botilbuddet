package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
	private ArrayList<Period> periods;
	private String name;
	private String year;
	private String month;
	private String description;
	
	
	public Schedule(String name, String description) {
		periods = new ArrayList<>();
		this.name = name;
		this.description = description;
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");
		DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MMMM");
		this.year = date.format(formatterYear);
		this.month = date.format(formatterMonth);
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPeriod(Period period) {
		periods.add(period);
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
