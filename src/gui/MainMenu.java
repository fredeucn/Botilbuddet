package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnCreateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateSchedule.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowSchedules = new JButton("Se vagtplaner");
		btnShowSchedules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowSchedules.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowPatients = new JButton("Se patienter");
		btnShowPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowPatients.setEnabled(false);
		btnShowPatients.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnShowEmployees = new JButton("Se medarbejdere");
		btnShowEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

}
