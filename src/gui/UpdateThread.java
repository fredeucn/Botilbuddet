package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.ConnectDB;
import db.DataAccessException;
import db.ScheduleDB;
import model.Employee;
import model.Period;
import model.Schedule;

public class UpdateThread extends Thread {

	private int sleepTimer;
	private ArrayList<Schedule> schedules;
	private ScheduleDB scheduleDB;
	private boolean running;
	
	public UpdateThread() throws DataAccessException {
		sleepTimer = 10000;
		schedules = new ArrayList<>();
		scheduleDB = new ScheduleDB();
		running = true;
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				ResultSet resultSet = scheduleDB.checkDbUpdates();
				if (resultSet.next()) {
					Schedule schedule = buildObject(resultSet);
					if(!schedules.contains(schedule)) {
						schedules.add(schedule);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(sleepTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private Schedule buildObject(ResultSet resultSet) throws SQLException {
		Schedule schedule = new Schedule(
				resultSet.getString("name"),
				resultSet.getString("description"));
		return schedule;
	}
	
}
