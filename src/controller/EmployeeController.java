package controller;

import db.DataAccessException;
import db.EmployeeDB;
import model.Employee;

public class EmployeeController {
	private EmployeeDB employeeDB;
	
	public EmployeeController() throws DataAccessException {
		employeeDB = new EmployeeDB();
	}
	
	public Employee findEmployeeById(int id) throws DataAccessException {
		return employeeDB.findEmployeeById(id);
	}
}
