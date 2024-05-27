package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PatientController;
import controller.ScheduleController;
import db.DataAccessException;
import model.Employee;
import model.Patient;
import model.Period;

public class PeriodGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private CalendarCell calendarCell;
	private PatientController patientController;
	private ScheduleController scheduleController;
	private LocalDate date;
	private Employee employee;
	
	private JComboBox choosePatient;
	private JComboBox chooseType;
	private JLabel lblDateDisplay;
	private JLabel lblEmployeeDisplay;

	/**
	 * Create the frame.
	 * @throws DataAccessException 
	 */
	public PeriodGUI(CalendarCell calendarCell, ScheduleController scheduleController, LocalDate date, Employee employee) throws DataAccessException {
		this.calendarCell = calendarCell;
		this.scheduleController = scheduleController;
		this.date = date;
		this.employee = employee;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 468);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 100, 100, 0};
		gbl_panel.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDate = new JLabel("Dato:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		panel.add(lblDate, gbc_lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblDateDisplay = new JLabel("Dato:");
		lblDateDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDateDisplay = new GridBagConstraints();
		gbc_lblDateDisplay.anchor = GridBagConstraints.WEST;
		gbc_lblDateDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateDisplay.gridx = 1;
		gbc_lblDateDisplay.gridy = 1;
		panel.add(lblDateDisplay, gbc_lblDateDisplay);
		
		JLabel lblEmployee = new JLabel("Medarbejder:");
		GridBagConstraints gbc_lblEmployee = new GridBagConstraints();
		gbc_lblEmployee.anchor = GridBagConstraints.EAST;
		gbc_lblEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployee.gridx = 0;
		gbc_lblEmployee.gridy = 2;
		panel.add(lblEmployee, gbc_lblEmployee);
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblEmployeeDisplay = new JLabel("Dato:");
		lblEmployeeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmployeeDisplay = new GridBagConstraints();
		gbc_lblEmployeeDisplay.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeDisplay.gridx = 1;
		gbc_lblEmployeeDisplay.gridy = 2;
		panel.add(lblEmployeeDisplay, gbc_lblEmployeeDisplay);
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPatient = new GridBagConstraints();
		gbc_lblPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatient.anchor = GridBagConstraints.EAST;
		gbc_lblPatient.gridx = 0;
		gbc_lblPatient.gridy = 3;
		panel.add(lblPatient, gbc_lblPatient);
		
		choosePatient = new JComboBox();
		choosePatient.setFont(new Font("Arial", Font.PLAIN, 14));
		choosePatient.setBackground(SystemColor.window);
		GridBagConstraints gbc_choosePatient = new GridBagConstraints();
		gbc_choosePatient.insets = new Insets(0, 0, 5, 5);
		gbc_choosePatient.fill = GridBagConstraints.HORIZONTAL;
		gbc_choosePatient.gridx = 1;
		gbc_choosePatient.gridy = 3;
		panel.add(choosePatient, gbc_choosePatient);
		
		JLabel lblType = new JLabel("Type: ");
		lblType.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 4;
		panel.add(lblType, gbc_lblType);
		
		chooseType = new JComboBox();
		chooseType.setModel(new DefaultComboBoxModel(new String[] {"Dag", "Aften", "Nat"}));
		chooseType.setFont(new Font("Arial", Font.PLAIN, 14));
		chooseType.setBackground(SystemColor.window);
		GridBagConstraints gbc_chooseType = new GridBagConstraints();
		gbc_chooseType.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseType.insets = new Insets(0, 0, 5, 5);
		gbc_chooseType.gridx = 1;
		gbc_chooseType.gridy = 4;
		panel.add(chooseType, gbc_chooseType);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTitle = new JLabel("Opret Periode");
		topPanel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel botPanel = new JPanel();
		contentPane.add(botPanel, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Annuller");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel();
			}
		});
		btnCancel.setBackground(new Color(255, 240, 240));
		botPanel.add(btnCancel);
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnAccept = new JButton("Godkend");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnAccept();
				} catch (DataAccessException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAccept.setBackground(new Color(240, 255, 240));
		btnAccept.setFont(new Font("Arial", Font.PLAIN, 14));
		botPanel.add(btnAccept);
		
		
		
		
		init();
	}

	private void init() throws DataAccessException {
		patientController = new PatientController();
		lblDateDisplay.setText(date.toString());
		lblEmployeeDisplay.setText(employee.getEmployeeId() + ". " + employee.getName());
		choosePatient.setRenderer(new PatientLinesRenderer());
		updateChoosePatients();
	}
	
	private void updateChoosePatients() throws DataAccessException {
		ArrayList<Patient> patients = patientController.findPatients(); // fetch patients from database
		for (Patient currentPatient : patients) {
			choosePatient.addItem(currentPatient); // add each found patient to ComboBox
		}
	}
	
	private void btnAccept() throws DataAccessException {
		Patient patient = (Patient) choosePatient.getSelectedItem();
		scheduleController.findPatientById(patient.getPatientId());
		scheduleController.chooseType(chooseType.getSelectedItem().toString());
		Period period = scheduleController.addPeriod();
		calendarCell.addPeriod(period);
		dispose();
	}
	
	private void btnCancel() {
		dispose();
	}
}
