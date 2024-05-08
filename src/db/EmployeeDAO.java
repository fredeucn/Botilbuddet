package db;

import model.Employee;

public interface EmployeeDAO {
	
	public Employee findEmployeeById(int id) throws DataAccessException;
	
}
