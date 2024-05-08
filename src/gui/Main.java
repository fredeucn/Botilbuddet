package gui;

import controller.EmployeeController;
import db.DataAccessException;
import model.Employee;

public class Main {
	private static EmployeeController employeeController;
	
	public static void main(String[] args) throws DataAccessException {
		employeeController = new EmployeeController();
		Employee e = employeeController.findEmployeeById(1);
		System.out.println(e.toString());
	}
}
