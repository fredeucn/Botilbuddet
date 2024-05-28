package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DataAccessException;
import db.ScheduleDB;
import model.Schedule;

public class UpdateThread extends Thread {

	private int sleepTimer;
	private ArrayList<Schedule> schedules;
	private ScheduleDB scheduleDB;
	
	public UpdateThread() throws DataAccessException {
		sleepTimer = 10000;
		schedules = new ArrayList<>();
		scheduleDB = new ScheduleDB();
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println("Checkpoint");
			try {
				ArrayList<Schedule> schedules = scheduleDB.findAllSchedules();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
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
