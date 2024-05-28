package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.EmployeeController;
import controller.ScheduleController;
import db.DataAccessException;
import model.Employee;

/*
 * Inspiration and kick start for the calendar functionality
 * https://www.youtube.com/watch?v=YivaMCfichQ
 */

public class ScheduleGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private ScheduleController scheduleController;
	private EmployeeController employeeController;
	private PanelCalendar calendarPanel;
	private JLabel lblMonthYear;
	private JComboBox<Employee> chooseEmployee;
	private static UpdateThread updateThread;
	
	/**
	 * Launch the application.
	 * @throws DataAccessException 
	 */
	public static void main(String[] args) throws DataAccessException {
		updateThread = new UpdateThread();
		updateThread.start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleGUI frame = new ScheduleGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws DataAccessException 
	 */
	public ScheduleGUI() throws DataAccessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 828);
		JPanel contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[] {150, 175, 150};
		gbl_topPanel.rowHeights = new int[] {40, 40, 40};
		gbl_topPanel.columnWeights = new double[]{1.0, 0.0, 1.0};
		gbl_topPanel.rowWeights = new double[]{0.0, 1.0, 0.0};
		topPanel.setLayout(gbl_topPanel);
		
		JButton btnAutoSchedule = new JButton("Autofyld Vagtplan");
		btnAutoSchedule.setBackground(new Color(255, 255, 255));
		btnAutoSchedule.setEnabled(false);
		btnAutoSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAutoSchedule = new GridBagConstraints();
		gbc_btnAutoSchedule.anchor = GridBagConstraints.WEST;
		gbc_btnAutoSchedule.insets = new Insets(5, 5, 5, 5);
		gbc_btnAutoSchedule.gridx = 0;
		gbc_btnAutoSchedule.gridy = 0;
		topPanel.add(btnAutoSchedule, gbc_btnAutoSchedule);
		
		JLabel lblTitle = new JLabel("Lav Vagtplan");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		topPanel.add(lblTitle, gbc_lblTitle);
		
		JButton btnSaveSchedule = new JButton("Frigiv Vagtplan");
		btnSaveSchedule.setBackground(new Color(255, 255, 255));
		btnSaveSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSaveSchedule = new GridBagConstraints();
		gbc_btnSaveSchedule.insets = new Insets(5, 5, 5, 0);
		gbc_btnSaveSchedule.anchor = GridBagConstraints.EAST;
		gbc_btnSaveSchedule.gridx = 2;
		gbc_btnSaveSchedule.gridy = 0;
		topPanel.add(btnSaveSchedule, gbc_btnSaveSchedule);
		
		JLabel lblEmployee = new JLabel("Medarbejder:");
		lblEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmployee = new GridBagConstraints();
		gbc_lblEmployee.insets = new Insets(5, 5, 5, 5);
		gbc_lblEmployee.anchor = GridBagConstraints.EAST;
		gbc_lblEmployee.gridx = 0;
		gbc_lblEmployee.gridy = 1;
		topPanel.add(lblEmployee, gbc_lblEmployee);
		
		chooseEmployee = new JComboBox<Employee>();
		chooseEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeSelected();
			}
		});
		chooseEmployee.setBackground(SystemColor.window);
		chooseEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_chooseEmployee = new GridBagConstraints();
		gbc_chooseEmployee.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseEmployee.insets = new Insets(5, 5, 5, 5);
		gbc_chooseEmployee.gridx = 1;
		gbc_chooseEmployee.gridy = 1;
		topPanel.add(chooseEmployee, gbc_chooseEmployee);
		
		JButton btnMonthLeft = new JButton("<");
		btnMonthLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMonthLeft();
			}
		});
		btnMonthLeft.setBackground(SystemColor.window);
		btnMonthLeft.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnMonthLeft = new GridBagConstraints();
		gbc_btnMonthLeft.anchor = GridBagConstraints.EAST;
		gbc_btnMonthLeft.insets = new Insets(5, 5, 0, 5);
		gbc_btnMonthLeft.gridx = 0;
		gbc_btnMonthLeft.gridy = 2;
		topPanel.add(btnMonthLeft, gbc_btnMonthLeft);
		
		lblMonthYear = new JLabel("Januar - 2023");
		lblMonthYear.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMonthYear = new GridBagConstraints();
		gbc_lblMonthYear.insets = new Insets(5, 5, 0, 5);
		gbc_lblMonthYear.gridx = 1;
		gbc_lblMonthYear.gridy = 2;
		topPanel.add(lblMonthYear, gbc_lblMonthYear);
		
		JButton btnMonthRight = new JButton(">");
		btnMonthRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMonthRight();
			}
		});
		btnMonthRight.setBackground(SystemColor.window);
		btnMonthRight.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnMonthRight = new GridBagConstraints();
		gbc_btnMonthRight.anchor = GridBagConstraints.WEST;
		gbc_btnMonthRight.insets = new Insets(5, 5, 0, 0);
		gbc_btnMonthRight.gridx = 2;
		gbc_btnMonthRight.gridy = 2;
		topPanel.add(btnMonthRight, gbc_btnMonthRight);
		
		calendarPanel = new PanelCalendar();
		contentPane.add(calendarPanel, BorderLayout.CENTER);
		
        
        
        
        
        init();
	}

	private void init() throws DataAccessException {
		chooseEmployee.setRenderer(new EmployeeLinesRenderer());
		scheduleController = new ScheduleController();
		employeeController = new EmployeeController();
		scheduleController.createSchedule("initial schedule", "no description");
		updateMonthYearLabel();
		updateChooseEmployee();
	}
	
	// triggers when a new employee is selected in the combo box
	private void employeeSelected() {
		
	}
	
	private void updateChooseEmployee() throws DataAccessException {
		ArrayList<Employee> employees = employeeController.getEmployees(); // fetch employees from database
		for (Employee currentEmployee : employees) {
			chooseEmployee.addItem(currentEmployee); // add each found employee to ComboBox
		}
	}

	private void updateMonthYearLabel() {
		LocalDate date = calendarPanel.getDate();
		lblMonthYear.setText(date.getMonth() + " - " + date.getYear());
	}
	
	private void btnMonthLeft() {
		LocalDate date = calendarPanel.getDate();
		date = date.minusMonths(1);
		calendarPanel.setDate(date.getMonthValue(), date.getYear(), scheduleController.getCurrentSchedule().getPeriods());
		updateMonthYearLabel();
	}

	private void btnMonthRight() {
		LocalDate date = calendarPanel.getDate();
		date = date.plusMonths(1);
		calendarPanel.setDate(date.getMonthValue(), date.getYear(), scheduleController.getCurrentSchedule().getPeriods());
		updateMonthYearLabel();
	}
	
	/*
	 * triggers when a cell in the calendar is clicked
	 * this returns a date, we create a new shift from the schedule controller
	 */
	public void calendarCellClicked(CalendarCell calendarCell) throws DataAccessException {
		Employee employee = (Employee) chooseEmployee.getSelectedItem();
		scheduleController.findEmployeeById(employee.getEmployeeId());
		
		LocalDate localDate = calendarCell.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert date to local date
		scheduleController.chooseDate(localDate);
		
		// open a new periodGUI for user inputs to create the final shift
		Frame periodGUI = new PeriodGUI(calendarCell, scheduleController, localDate, employee);
		periodGUI.setVisible(true);
	}
}
