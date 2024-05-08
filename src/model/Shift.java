package model;

import java.time.LocalDate;

public class Shift extends Period {

	private String type;
	private float overtimeSalary;
	private Patient patient;
	
	public Shift(String type, float overtimeSalary, Patient patient, LocalDate startDate, LocalDate endDate) {
		super(startDate, endDate);
		this.type = type;
		this.overtimeSalary = overtimeSalary;
		this.patient = patient;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setOvertimeSalary(float overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	} 
	
	public Patient getPatient() {
		return patient;
	}
	
	public float getOvertimeSalary() {
		return overtimeSalary;
	}
	
	public String getType() {
		return type;
	}
}
