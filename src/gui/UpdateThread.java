package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import db.DataAccessException;
import db.ScheduleDB;
import model.Schedule;

public class UpdateThread extends Thread {

	/*
	 * UpdateThread klassens arbejde, er at hente alle Schedules fra databasen med et fast interval,
	 * og derefter gemmer den informationen i en DefaultListModel, som kan vises i ScheduleOverviewGUI via en JList
	 */
	
	
	private int sleepTimer;
	private ScheduleOverviewGUI gui;
	
	public UpdateThread(ScheduleOverviewGUI gui) throws DataAccessException {
		sleepTimer = 10000;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(sleepTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				gui.updateSchedulesList();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
