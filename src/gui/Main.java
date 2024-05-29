package gui;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;

import controller.EmployeeController;
import controller.PatientController;
import controller.ScheduleController;
import db.DataAccessException;
import model.Employee;
import model.Patient;

public class Main {
	/*
	private static EmployeeController employeeController;
	private static PatientController patientController;
	private static ScheduleController scheduleController;
	*/
	
	public static void main(String[] args) throws DataAccessException, SQLException {
		/*
		employeeController = new EmployeeController();
		patientController = new PatientController();
		scheduleController = new ScheduleController();
		Employee employee = employeeController.findEmployeeById(1);
		System.out.println(employee.toString());
		
		Patient patient = patientController.findPatientById(2);
		System.out.println(patient.toString());
		
		scheduleController.createSchedule("propzchedule", "Schedule for props");
		
		scheduleController.findEmployeeById(2);
		scheduleController.findPatientById(1);
		scheduleController.chooseDate(LocalDate.now().plusMonths(2));
		scheduleController.chooseType("dag");
		scheduleController.addPeriod();
		
		scheduleController.findEmployeeById(1);
		scheduleController.findPatientById(2);
		scheduleController.chooseDate(LocalDate.now().plusMonths(3));
		scheduleController.chooseType("aften");
		scheduleController.addPeriod();

		scheduleController.saveSchedule();
		*/
		
		JFrame mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}
}