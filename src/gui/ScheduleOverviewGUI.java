package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Schedule;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;

import db.DataAccessException;
import db.ScheduleDB;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ScheduleOverviewGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String[] schedules = {"test"};
	private static UpdateThread updateThread;
	private static ArrayList<Schedule> test;
	private static DefaultListModel<String> listModel;

	/**
	 * Launch the application.
	 * @throws DataAccessException 
	 */
	public static void main(String[] args) throws DataAccessException {
		
		test = new ArrayList<>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleOverviewGUI frame = new ScheduleOverviewGUI();
					frame.setVisible(true);
					updateThread = new UpdateThread(frame.getListModel());
					updateThread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	public DefaultListModel<String> getListModel() {
        return listModel;
    }

	/**
	 * Create the frame.
	 */
	public ScheduleOverviewGUI() {
		
		listModel = new DefaultListModel<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.SOUTH);
		
        JList<String> list = new JList<>(listModel);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		
		JButton btnAddTestData = new JButton("Add Test Data");
		btnAddTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateList2();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnAddTestData, BorderLayout.NORTH);
		
		
		
		
	}
	
	public static void updateList(ArrayList<Schedule> list) {
		list.toArray(schedules);
	}
	
	public static void updateList2() throws DataAccessException {
		ScheduleDB scheduleDB = new ScheduleDB();
		Schedule schedule = new Schedule("test", "test");
		schedule.setDate(LocalDate.now());
		try {
			scheduleDB.saveSchedule(schedule);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
