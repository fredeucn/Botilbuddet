package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import db.DataAccessException;
import db.ScheduleDB;
import model.Schedule;
import model.Shift;

public class ScheduleController {
	private EmployeeController employeeController;
	private PatientController patientController;
	private ScheduleDB scheduleDB;
	private Schedule currentSchedule;
	private Shift currentShift;
	private LocalDate currentDate;
	
	public ScheduleController() throws DataAccessException {
		employeeController = new EmployeeController();
		patientController = new PatientController();
	}
	
	public void createSchedule(String name, String description) {
		currentSchedule = new Schedule(name, description);
	}
	
	public void findEmployeeById(int id) throws DataAccessException {
		currentShift = new Shift(null, 0, null, null, null, employeeController.findEmployeeById(id));
	}
	
	public void findPatientById(int id) throws DataAccessException {
		currentShift.setPatient(patientController.findPatientById(id));
	}
	
	public void chooseDate(LocalDate date) {
		currentDate = date;
	}
	
	public void chooseType(String type) {
		int startTimeHours = 0;
		int startTimeMinutes = 0;
		int endTimeHours = 0;
		int endTimeMinutes = 0;
		
		if(type == "dag") {
			startTimeHours = 8;
			startTimeMinutes = 0;
			endTimeHours = 16;
			endTimeMinutes = 0;
		} else if(type == "aften") {
			startTimeHours = 16;
			startTimeMinutes = 0;
			endTimeHours = 23;
			endTimeMinutes = 59;
		} else if(type == "nat") {
			startTimeHours = 0;
			startTimeMinutes = 0;
			endTimeHours = 8;
			endTimeMinutes = 0;
		}
		
		LocalDateTime startDateTime = LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth(), startTimeHours, startTimeMinutes);
		LocalDateTime endDateTime = LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth(), endTimeHours, endTimeMinutes);
		
		currentShift.setStartTime(startDateTime);
		currentShift.setEndTime(endDateTime);
	}
	
	public void addPeriod() {
		currentSchedule.addPeriod(currentShift);
	}
	
	public void saveSchedule(Schedule currentSchedule) {
		scheduleDB.saveSchedule(currentSchedule);
	}
}	

