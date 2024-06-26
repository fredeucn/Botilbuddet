package controller;

import java.util.ArrayList;

import db.DataAccessException;
import db.EmployeeDB;
import model.Employee;

public class EmployeeController {
	private EmployeeDB employeeDB;
	private Employee currentEmployee;
	
	public EmployeeController() throws DataAccessException {
		employeeDB = new EmployeeDB();
	}
	
	public Employee findEmployeeById(int id) throws DataAccessException {
		return currentEmployee = employeeDB.findEmployeeById(id);
	}

	public Employee getCurrentEmployee() {
		return currentEmployee;
	}
	
	public ArrayList<Employee> getEmployees() throws DataAccessException {
		return employeeDB.findEmployees();
	}
}
