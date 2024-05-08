package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class EmployeeDB implements EmployeeDAO {
	
	// remember " " spaces when splitting up the Query with +
	private static final String findEmployeeQuery = "SELECT employee.id, phone_number, employee.name, employee.email, salary, employee_type, city.zip, street_name, house_number, city.name as city_name FROM employee "
			+ "INNER JOIN address ON employee.address_id = address.id "
			+ "INNER JOIN city ON address.city_zip = city.zip "
			+ "WHERE employee.id = ?";
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
	public Employee findEmployeeById(int id) throws DataAccessException {
		try {
			findEmployee.setInt(1, id);
			ResultSet resultSet = findEmployee.executeQuery();
			Employee employee = null;
			if (resultSet.next()) {
				employee = buildObject(resultSet);
			}
			return employee;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find employee by id = " + id);
		}
	}
	
	private Employee buildObject(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee(
				resultSet.getString("name"),
				resultSet.getString("employee_type"),
				resultSet.getString("email"),
				resultSet.getString("phone_number"),
				resultSet.getString("street_name") + " " + resultSet.getString("house_number") + " " + resultSet.getString("zip") + " " + resultSet.getString("city_name"),
				resultSet.getFloat("salary"),
				resultSet.getInt("id"));
		return employee;
	}
	
	
}
