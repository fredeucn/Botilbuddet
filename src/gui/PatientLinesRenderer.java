package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Patient;

public class PatientLinesRenderer implements ListCellRenderer<Patient>{
	private DefaultListCellRenderer dlcr = new DefaultListCellRenderer();

	@Override
	public Component getListCellRendererComponent(JList<? extends Patient> list, Patient value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		String res = value.getPatientId() + ": " + value.getName();
		
		return dlcr.getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}

}
