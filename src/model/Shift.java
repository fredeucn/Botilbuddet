package model;

import java.time.LocalDateTime;

public class Shift extends Period {

	private String type;
	private float overtimeSalary;
	private Patient patient;
	
	public Shift(String type, float overtimeSalary, Patient patient, LocalDateTime startDate, LocalDateTime endDate, Employee employee) {
		super(startDate, endDate, employee);
		this.type = type;
		this.overtimeSalary = overtimeSalary;
		this.patient = patient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getOvertimeSalary() {
		return overtimeSalary;
	}

	public void setOvertimeSalary(float overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
