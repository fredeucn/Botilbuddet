package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.DataAccessException;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Main Menu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel, BorderLayout.CENTER);
		
		JButton btnCreateSchedule = new JButton("Lav ny vagtplan");
		btnCreateSchedule.setBackground(SystemColor.window);
		btnCreateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					createScheduleClicked();
				} catch (DataAccessException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowSchedules = new JButton("Se vagtplaner");
		btnShowSchedules.setBackground(SystemColor.window);
		btnShowSchedules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showSchedulesClicked();
				} catch (DataAccessException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowSchedules.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowPatients = new JButton("Se patienter");
		btnShowPatients.setBackground(SystemColor.window);
		btnShowPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPatientsClicked();
			}
		});
		btnShowPatients.setEnabled(false);
		btnShowPatients.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowEmployees = new JButton("Se medarbejdere");
		btnShowEmployees.setBackground(SystemColor.window);
		btnShowEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployeeClicked();
			}
		});
		btnShowEmployees.setEnabled(false);
		btnShowEmployees.setFont(new Font("Arial", Font.PLAIN, 14));
		FlowLayout fl_buttonsPanel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		buttonsPanel.setLayout(fl_buttonsPanel);
		buttonsPanel.add(btnCreateSchedule);
		buttonsPanel.add(btnShowSchedules);
		buttonsPanel.add(btnShowPatients);
		buttonsPanel.add(btnShowEmployees);
	}

	private void showEmployeeClicked() {
		// TODO Auto-generated method stub
		
	}

	private void showPatientsClicked() {
		// TODO Auto-generated method stub
		
	}

	private void showSchedulesClicked() throws DataAccessException {
		JFrame schedulesListGUI = new ScheduleOverviewGUI();
		schedulesListGUI.setVisible(true);
	}

	private void createScheduleClicked() throws DataAccessException {
		JFrame scheduleGUI = new ScheduleGUI();
		scheduleGUI.setVisible(true);
	}

}
