package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScheduleGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel CalendarPanel;
	private JLabel lblMonthYear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public ScheduleGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 635);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[] {150, 175, 150};
		gbl_topPanel.rowHeights = new int[] {40, 40, 40};
		gbl_topPanel.columnWeights = new double[]{1.0, 0.0, 1.0};
		gbl_topPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
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
		
		JLabel lblEmployee = new JLabel("Medarbejder ");
		lblEmployee.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmployee = new GridBagConstraints();
		gbc_lblEmployee.insets = new Insets(5, 5, 5, 5);
		gbc_lblEmployee.anchor = GridBagConstraints.EAST;
		gbc_lblEmployee.gridx = 0;
		gbc_lblEmployee.gridy = 1;
		topPanel.add(lblEmployee, gbc_lblEmployee);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.window);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"John"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		topPanel.add(comboBox, gbc_comboBox);
		
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
		
		CalendarPanel = new PanelCalendar(5, 2024);
		contentPane.add(CalendarPanel, BorderLayout.CENTER);
		
        
        
        
        
        
        init();
	}

	private void init() {
		
		
		
		
	}
	
	private void updateMonthYearLabel() {
		
	}
	
	private void btnMonthLeft() {
		
	}

	private void btnMonthRight() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
