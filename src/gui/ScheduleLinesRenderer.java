package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Schedule;

public class ScheduleLinesRenderer implements ListCellRenderer<Schedule> {
	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

	@Override
	public Component getListCellRendererComponent(JList<? extends Schedule> list, 
			Schedule value, int index, boolean isSelected, boolean cellHasFocus) {
		
		String res = value.getName() + " - " + value.getDescription();
		
		return dlcr.getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}
}
