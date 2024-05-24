package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;

public class EmployeeDB implements EmployeeDAO {
	
	// remember " " spaces when splitting up the Query with +
	private static final String findEmployeeByIdQuery = "SELECT employee.id, phone_number, employee.name, employee.email, salary, employee_type, city.zip, street_name, house_number, city.name as city_name FROM employee "
			+ "INNER JOIN address ON employee.address_id = address.id "
			+ "INNER JOIN city ON address.city_zip = city.zip "
			+ "WHERE employee.id = ?";
	private static final String findEmployeesQuery = "SELECT employee.id, phone_number, employee.name, employee.email, salary, employee_type, city.zip, street_name, house_number, city.name as city_name FROM employee "
			+ "INNER JOIN address ON employee.address_id = address.id "
			+ "INNER JOIN city ON address.city_zip = city.zip";
	private PreparedStatement findEmployeeById, findEmployees;

	public EmployeeDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			findEmployeeById = connection.prepareStatement(findEmployeeByIdQuery);
			findEmployees = connection.prepareStatement(findEmployeesQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public Employee findEmployeeById(int id) throws DataAccessException {
		try {
			findEmployeeById.setInt(1, id);
			ResultSet resultSet = findEmployeeById.executeQuery();
			Employee employee = null;
			if (resultSet.next()) {
				employee = buildObject(resultSet);
			}
			return employee;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find employee by id = " + id);
		}
	}
	
	@Override
	public ArrayList<Employee> findEmployees() throws DataAccessException {
		try {
			ArrayList<Employee> employees = new ArrayList<>();
			ResultSet resultSet = findEmployees.executeQuery();
			while (resultSet.next()) {
				employees.add(buildObject(resultSet));
			}
			return employees;
		} catch (SQLException e) {
			throw new DataAccessException(e, "No employees could be found or access to database failed");
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
