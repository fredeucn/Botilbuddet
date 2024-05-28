package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Schedule;

public interface ScheduleDAO {
	public void saveSchedule(Schedule schedule) throws SQLException;
	public ArrayList<Schedule> findAllSchedules() throws DataAccessException;
}
