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

public class ScheduleGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
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
		gbl_topPanel.columnWidths = new int[] {150, 200, 150};
		gbl_topPanel.rowHeights = new int[] {40, 40};
		gbl_topPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_topPanel.rowWeights = new double[]{0.0, 0.0};
		topPanel.setLayout(gbl_topPanel);
		
		JLabel lblTitle = new JLabel("Lav Vagtplan");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(5, 5, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		topPanel.add(lblTitle, gbc_lblTitle);
		
		JButton btnAutoSchedule = new JButton("Autofyld Vagtplan");
		btnAutoSchedule.setBackground(new Color(255, 255, 255));
		btnAutoSchedule.setEnabled(false);
		btnAutoSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAutoSchedule = new GridBagConstraints();
		gbc_btnAutoSchedule.anchor = GridBagConstraints.WEST;
		gbc_btnAutoSchedule.insets = new Insets(5, 5, 5, 5);
		gbc_btnAutoSchedule.gridx = 0;
		gbc_btnAutoSchedule.gridy = 1;
		topPanel.add(btnAutoSchedule, gbc_btnAutoSchedule);
		
		JButton btnSaveSchedule = new JButton("Frigiv Vagtplan");
		btnSaveSchedule.setBackground(new Color(255, 255, 255));
		btnSaveSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSaveSchedule = new GridBagConstraints();
		gbc_btnSaveSchedule.insets = new Insets(5, 5, 5, 5);
		gbc_btnSaveSchedule.anchor = GridBagConstraints.EAST;
		gbc_btnSaveSchedule.gridx = 2;
		gbc_btnSaveSchedule.gridy = 1;
		topPanel.add(btnSaveSchedule, gbc_btnSaveSchedule);
		
		JPanel CalendarPanel = new PanelCalendar(5, 2024);
		contentPane.add(CalendarPanel, BorderLayout.CENTER);
		
        
        
        
        
        
        init();
	}

	private void init() {
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
