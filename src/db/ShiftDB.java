package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Shift;

public class ShiftDB implements ShiftDAO {
	private static final String saveShiftQuery = "insert into period (period_id, type, overtime_salary, patient_id) values ( ?, ?, ?, ?)";
	private PreparedStatement saveShift;
	
	public ShiftDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			saveShift = connection.prepareStatement(saveShiftQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	@Override
	public void saveShift(Shift shift, int periodId) throws SQLException {
		saveShift.setInt(1, periodId);
		saveShift.setString(2, shift.getType());
		saveShift.setFloat(3, shift.getOvertimeSalary());
		saveShift.setInt(4, shift.getPatient().getPatientId());
		
		saveShift.executeQuery();
		
	}
	
}
