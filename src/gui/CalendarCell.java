package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Period;

public class CalendarCell extends JButton {

	private static final long serialVersionUID = 1L;
	private Date date;
	private boolean title;
	private ArrayList<Period> periods;
	
	public CalendarCell() {
		periods = new ArrayList<>();
		setContentAreaFilled(false);
		setLayout(new GridLayout(0, 1, 10, 10)); // makes it possible to add multiple labels to our custom button
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
	
	public void addPeriod(Period period) {
		periods.add(period);
		updateLabels();
	}
	
	private void updateLabels() {
		removeAll();
		for (Period currentPeriod : periods) {
			JLabel label = new JLabel(); // create new label
			
			String displayText = ""; // construct a display text
			displayText += currentPeriod.getStartTime().getHour() + ":" + currentPeriod.getStartTime().getMinute();
			displayText += " - " + currentPeriod.getEndTime().getHour() + ":" + currentPeriod.getEndTime().getMinute();
			
			label.setText(displayText); // set display text of label
			label.setFont(new Font("Arial", Font.PLAIN, 14));
			
			add(label);
		}
	}
}
