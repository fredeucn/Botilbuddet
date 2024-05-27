package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import db.DataAccessException;
import db.ScheduleDB;
import model.Period;
import model.Schedule;
import model.Shift;

public class ScheduleController {
	private EmployeeController employeeController;
	private PatientController patientController;
	private ScheduleDB scheduleDB;
	private Schedule currentSchedule;
	private Shift currentShift;
	private LocalDate currentDate;
	
	public Schedule getCurrentSchedule() {
		return currentSchedule;
	}

	public ScheduleController() throws DataAccessException {
		employeeController = new EmployeeController();
		patientController = new PatientController();
		scheduleDB = new ScheduleDB();
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
		
		if(type == "Dag") {
			startTimeHours = 8;
			startTimeMinutes = 0;
			endTimeHours = 16;
			endTimeMinutes = 0;
		} else if(type == "Aften") {
			startTimeHours = 16;
			startTimeMinutes = 0;
			endTimeHours = 23;
			endTimeMinutes = 59;
		} else if(type == "Nat") {
			startTimeHours = 0;
			startTimeMinutes = 0;
			endTimeHours = 8;
			endTimeMinutes = 0;
		}
		
		LocalDateTime startDateTime = LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth(), startTimeHours, startTimeMinutes);
		LocalDateTime endDateTime = LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth(), endTimeHours, endTimeMinutes);
		
		currentShift.setStartTime(startDateTime);
		currentShift.setEndTime(endDateTime);
		currentShift.setType(type);
	}
	
	public Period addPeriod() {
		Period period = null;
		
		if (currentSchedule.getDate() == null) { // set date of schedule based on the first period added to schedule
			currentSchedule.setDate(currentDate);
		}
		
		if (currentSchedule.getDate().getMonthValue() == currentDate.getMonthValue()) {
			// period added, period matches month of schedule
			currentSchedule.addPeriod(currentShift);
			period = currentShift;
		}
		
		return period;
	}
	
	public void saveSchedule() throws SQLException {
		scheduleDB.saveSchedule(currentSchedule);
	}
	
}	

