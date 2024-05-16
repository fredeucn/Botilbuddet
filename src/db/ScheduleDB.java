package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import model.Period;
import model.Schedule;

public class ScheduleDB implements ScheduleDAO{
	PeriodDB periodDB;
	
	private static final String saveScheduleQuery = "insert into schedule (name, description, date) values ( ?, ?, ?)";
	private static final String getScheduleQueryId = "select id from schedule where name = ?";
	private PreparedStatement saveSchedule;
	private PreparedStatement getScheduleId;

	public ScheduleDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			saveSchedule = connection.prepareStatement(saveScheduleQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	@Override
	public void saveSchedule(Schedule schedule) throws SQLException {
		saveSchedule.setString(1, schedule.getName());
		saveSchedule.setString(2, schedule.getDescription());
		saveSchedule.setString(3, schedule.getMonth());
		
		ResultSet resultSet1 = getScheduleId.executeQuery();
		ResultSet resultSet2 = saveSchedule.executeQuery();
		
		int scheduleId = resultSet1.getInt("id");
		// TODO Auto-generated method stub
		for(Period period: schedule.getPeriods()) {
			periodDB.savePeriod(period, scheduleId);
		}
		
	}

}
