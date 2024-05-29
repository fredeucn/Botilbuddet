package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import db.DataAccessException;
import db.ScheduleDB;
import model.Schedule;

public class ScheduleOverviewGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JList<Schedule> lstSchedules;
	private ScheduleDB scheduleDB;
	
	/**
	 * Create the frame.
	 * @throws DataAccessException 
	 */
	public ScheduleOverviewGUI() throws DataAccessException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Vagtplaner");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(lblTitle, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        lstSchedules = new JList<Schedule>();
        lstSchedules.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollPane.setViewportView(lstSchedules);
		
		
		
		
        
		init();
	}
	
	
	private void init() throws DataAccessException {
		lstSchedules.setCellRenderer(new ScheduleLinesRenderer());
		scheduleDB = new ScheduleDB();
		Thread updateThread = new UpdateThread(this);
		updateThread.start();
		updateSchedulesList();
	}
	
	public void updateSchedulesList() throws DataAccessException {
		SwingUtilities.invokeLater(() -> {
			try {
				DefaultListModel<Schedule> dlm = new DefaultListModel<Schedule>();
				dlm.addAll(scheduleDB.findAllSchedules());
				lstSchedules.setModel(dlm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
