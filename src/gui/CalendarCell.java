package gui;

import java.awt.Color;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class CalendarCell extends JButton {

	private static final long serialVersionUID = 1L;
	private Date date;
	private boolean title;
	
	public CalendarCell() {
		setContentAreaFilled(false);
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
			setForeground(new Color(70, 70, 70));
		} else {
			setForeground(new Color(170, 170, 170));
		}
	}
}
