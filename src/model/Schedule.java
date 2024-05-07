package model;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<Period> periods;
	private String name;
	private String year;
	private String month;
	private String description;
	
	
	public Schedule() {
		// TODO Auto-generated constructor stub
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
	
	public void setPeriods(ArrayList<Period> periods) {
		this.periods = periods;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
