package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class EmployeeDB implements EmployeeDAO {
	
	
	private static final String findEmployeeQuery = "SELECT phone_number, name, employee_type, city.zip, street_name, street_number, city "
			+ "FROM employee INNER JOIN address ON employee.address_id = address.id "
			+ "INNER JOIN city ON address.zip = city.zip "
			+ "WHERE id = ?";
	private PreparedStatement findEmployee;

	public EmployeeDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			findEmployee = connection.prepareStatement(findEmployeeQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public Employee findEmployeeById(int id) {
		return null;
	}
	
	private Employee buildObject(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee(
				resultSet.getString("name"),
				resultSet.getString("employee_type"),
				resultSet.getString("email"),
				resultSet.getString("phone_number"),
				resultSet.getString("street_name") + " " + resultSet.getString("street_number") + " " + resultSet.getString("zip") + " " + resultSet.getString("city"),
				resultSet.getFloat("salary"),
				resultSet.getInt("id"));
		return employee;
	}
	
	
}
