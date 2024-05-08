package gui;

import controller.EmployeeController;
import controller.PatientController;
import db.DataAccessException;
import model.Employee;
import model.Patient;

public class Main {
	private static EmployeeController employeeController;
	private static PatientController patientController;
	
	public static void main(String[] args) throws DataAccessException {
		employeeController = new EmployeeController();
		patientController = new PatientController();
		
		Employee employee = employeeController.findEmployeeById(1);
		System.out.println(employee.toString());
		
		Patient patient = patientController.findPatientById(2);
		System.out.println(patient.toString());
	}
}
