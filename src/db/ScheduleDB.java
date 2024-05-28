package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Period;
import model.Schedule;
import model.Shift;

public class ScheduleDB implements ScheduleDAO{
	PeriodDB periodDB;
	
	private static final String saveScheduleQuery = "insert into schedule (name, description, date) values (?, ?, ?)";	
	private static final String findAllSchedulesQuery = "SELECT * FROM schedule";
	private PreparedStatement saveSchedule, findAllSchedules;
	
	public ScheduleDB() throws DataAccessException {
		periodDB = new PeriodDB();
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			saveSchedule = connection.prepareStatement(saveScheduleQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
			findAllSchedules = connection.prepareStatement(findAllSchedulesQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement saveScheduleQuery");
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
	public ArrayList<Schedule> findAllSchedules() throws DataAccessException {
		try {
			ArrayList<Schedule> schedules = new ArrayList<Schedule>();
			ResultSet resultSet = findAllSchedules.executeQuery();
			
			while (resultSet.next()) {
				schedules.add(buildObject(resultSet));
			}
			return schedules;
		} catch (Exception e) {
			throw new DataAccessException(e, "No schedules could be found or access to database failed");
		}
	}
	
	private Schedule buildObject(ResultSet resultSet) throws SQLException {
		Schedule schedule = new Schedule(
				resultSet.getString("name"),
				resultSet.getString("description"));
		return schedule;
	}
}
