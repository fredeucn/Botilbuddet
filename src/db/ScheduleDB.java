package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Period;
import model.Schedule;
import model.Shift;

public class ScheduleDB implements ScheduleDAO{
	private PeriodDB periodDB;
	
	private static final String saveScheduleQuery = "insert into schedule (name, description, date) values (?, ?, ?)";	
	private static final String findAllSchedulesQuery = "SELECT * FROM schedule";
	private PreparedStatement saveSchedule, findAllSchedules;
	
	public ScheduleDB() throws DataAccessException {
		periodDB = new PeriodDB();
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			saveSchedule = connection.prepareStatement(saveScheduleQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement saveScheduleQuery");
		}
		
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			findAllSchedules = connection.prepareStatement(findAllSchedulesQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement findAllSchedulesQuery");
		}
	}
	@Override
	public void saveSchedule(Schedule schedule) throws SQLException {
		// convert localDate to SQL date
		Date sqlDate = null;
		if(schedule.getDate() != null) {
			sqlDate = Date.valueOf(schedule.getDate());
		}
		
		saveSchedule.setString(1, schedule.getName());
		saveSchedule.setString(2, schedule.getDescription());
		saveSchedule.setDate(3, sqlDate);
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
	
	@Override
	public ResultSet checkDbUpdates() throws SQLException {
		ResultSet resultSet = findAllSchedules.executeQuery();
		return resultSet;
	}

}
