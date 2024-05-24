package db;

import java.util.ArrayList;

import model.Employee;

public interface EmployeeDAO {
	
	public Employee findEmployeeById(int id) throws DataAccessException;

	public ArrayList<Employee> findEmployees() throws DataAccessException;
	
}
