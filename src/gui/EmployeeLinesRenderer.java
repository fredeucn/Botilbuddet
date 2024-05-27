package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Employee;

public class EmployeeLinesRenderer implements ListCellRenderer<Employee>{
	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

	@Override
	public Component getListCellRendererComponent(JList<? extends Employee> list, Employee value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		String res = value.getEmployeeId() + ": " + value.getName();
		
		return dlcr.getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}
}
