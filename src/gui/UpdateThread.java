package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

import db.DataAccessException;
import db.ScheduleDB;
import model.Schedule;

public class UpdateThread extends Thread {

	private int sleepTimer;
	private ArrayList<Schedule> schedules;
	private ScheduleDB scheduleDB;
	private DefaultListModel<String> listModel;
	
	public UpdateThread(DefaultListModel<String> listModel) throws DataAccessException {
		sleepTimer = 10000;
		schedules = new ArrayList<>();
		scheduleDB = new ScheduleDB();
		this.listModel = listModel;
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println("Checkpoint");
			try {
				ArrayList<Schedule> schedules = scheduleDB.findAllSchedules();
				final DefaultListModel<String> newListModel = new DefaultListModel<>();
				for(Schedule curr : schedules) {
					newListModel.addElement("Name: " + curr.getName() + " Description: " + curr.getDescription());
				}
				
				SwingUtilities.invokeLater(() -> {
                    listModel.clear();
                    for (int i = 0; i < newListModel.size(); i++) {
                        listModel.addElement(newListModel.getElementAt(i));
                    }
				});
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
	
	public ArrayList<Schedule> getSchedules() {
		return schedules;
	}
	
}
