package db;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Period;
import model.Shift;

public class PeriodDB implements PeriodDAO{
	ShiftDB shiftDB;
	
	private static final String savePeriodQuery = "insert into period (start_date, end_date, schedule_id, employee_id, location_id) values ( ?, ?, ?, ?, ?)";
	private PreparedStatement savePeriod;

	
	public PeriodDB() throws DataAccessException {
		shiftDB = new ShiftDB();
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			savePeriod = connection.prepareStatement(savePeriodQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public void savePeriod(Shift shift, int scheduleId) throws SQLException {
		savePeriod.setTimestamp(1, java.sql.Timestamp.valueOf(shift.getStartTime()));
		savePeriod.setTimestamp(2, java.sql.Timestamp.valueOf(shift.getEndTime()));
		savePeriod.setInt(3, scheduleId); // forbinder Period med det rigtige Schedule i database
		savePeriod.setInt(4, shift.getEmployee().getEmployeeId());
		savePeriod.setInt(5, 1);
		savePeriod.executeUpdate();
		
		int periodId = 0;
		
		ResultSet key = savePeriod.getGeneratedKeys();
		if(key.next()) {
			periodId = key.getInt(1); // PeriodID forbinder Period og Shift i database
		}
		
		key.close();
		
		
		// TODO Auto-generated method stub
		shiftDB.saveShift(shift, periodId);
	}

}
