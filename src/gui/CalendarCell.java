package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import db.DataAccessException;
import model.Employee;
import model.Period;

/*
 * Inspiration and kick start for the calendar functionality
 * https://www.youtube.com/watch?v=YivaMCfichQ
 */

public class CalendarCell extends JButton {

	private static final long serialVersionUID = 1L;
	private Date date;
	private boolean title;
	private ArrayList<Period> periods;
	private Employee selectedEmployee;
	
	public CalendarCell() {
		periods = new ArrayList<>();
		setContentAreaFilled(false);
		setLayout(new GridLayout(0, 1, 10, 10)); // makes it possible to add multiple labels to our custom button
		addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					calendarCellClicked();
				} catch (DataAccessException e1) {
					e1.printStackTrace();
				}
        	}
        });
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isTitle() {
		return title;
	}

	public void setTitle(boolean title) {
		this.title = title;
	}
	
	public void inMonth(boolean active) {
		if (active) {
			setForeground(new Color(60, 60, 60));
		} else {
			setForeground(new Color(180, 180, 180));
		}
	}
	
	public void setPeriods(ArrayList<Period> periods) {
		this.periods = periods;
		updateLabels();
	}
	
	private void updateLabels() {
		removeAll();
		if (periods != null) {
			for (Period currentPeriod : periods) {
				if (currentPeriod.getEmployee().equals(selectedEmployee)) {
					LocalDate periodDate = currentPeriod.getStartTime().toLocalDate();
	                if (periodDate.equals(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
	                    JLabel label = new JLabel(); // create new label
	
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	                    String displayText = currentPeriod.getStartTime().format(formatter) + " - " +
	                                         currentPeriod.getEndTime().format(formatter);
	
	                    label.setText(displayText); // set display text of label
	                    label.setFont(new Font("Arial", Font.PLAIN, 14));
	
	                    // color
	                    label.setForeground(new Color(55, 120, 135));
	
	                    add(label);
	                }
				}
			}
		}
	}
	
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	private void calendarCellClicked() throws DataAccessException {
		if (!isTitle()) {
			PanelCalendar panelCalendar = (PanelCalendar) SwingUtilities.getAncestorOfClass(PanelCalendar.class, this);
			panelCalendar.calendarCellClicked(this);
		}
	}
}
