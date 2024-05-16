package db;

import java.sql.SQLException;

import model.Schedule;

public interface ScheduleDAO {
	public void saveSchedule(Schedule schedule) throws SQLException;
}
