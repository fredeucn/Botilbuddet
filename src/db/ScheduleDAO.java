package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Schedule;

public interface ScheduleDAO {
	public void saveSchedule(Schedule schedule) throws SQLException;
	public ResultSet checkDbUpdates() throws SQLException;
}
