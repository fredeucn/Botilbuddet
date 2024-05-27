package controller;

import java.util.ArrayList;

import db.DataAccessException;
import db.PatientDB;
import model.Patient;

public class PatientController {
	private PatientDB patientDB;
	private Patient currentPatient;
	
	public PatientController() throws DataAccessException {
		patientDB = new PatientDB();
	}
	
	public Patient findPatientById(int id) throws DataAccessException {
		return patientDB.findPatientById(id);
	}
	
	public ArrayList<Patient> findPatients() throws DataAccessException {
		return patientDB.findPatients();
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}
}
