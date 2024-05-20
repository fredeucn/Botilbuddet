package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import model.Period;
import model.Schedule;
import model.Shift;

public class ScheduleDB implements ScheduleDAO{
	PeriodDB periodDB;
	
	private static final String saveScheduleQuery = "insert into schedule (name, description, date) values (?, ?, ?)";	
	private PreparedStatement saveSchedule;
	
	public ScheduleDB() throws DataAccessException {
		periodDB = new PeriodDB();
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			saveSchedule = connection.prepareStatement(saveScheduleQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	@Override
	public void saveSchedule(Schedule schedule) throws SQLException {
		saveSchedule.setString(1, schedule.getName());
		saveSchedule.setString(2, schedule.getDescription());
		saveSchedule.setString(3, schedule.getMonth());
		saveSchedule.executeUpdate();
		int scheduleId = 0;
		
		ResultSet key = saveSchedule.getGeneratedKeys();
		if(key.next()) {
			scheduleId = key.getInt(1);
		}
		
		key.close();
		
		
		// TODO Auto-generated method stub
		for(Period period: schedule.getPeriods()) {
			 if (period instanceof Shift) {
			        Shift shift = (Shift) period;
			        periodDB.savePeriod(shift, scheduleId);
			    }
			
		}
		
	}

}
