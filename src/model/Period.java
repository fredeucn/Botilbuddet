package model;

import java.time.LocalDateTime;

public class Period {
	@Override
	public String toString() {
		return "Period [startTime=" + startTime + ", endTime=" + endTime + ", employee=" + employee + "]";
	}

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Employee employee;
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param employee
	 */
	public Period(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.employee = employee;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
