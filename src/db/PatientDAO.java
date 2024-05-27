package db;

import java.util.ArrayList;

import model.Patient;

public interface PatientDAO {
	public Patient findPatientById(int id) throws DataAccessException;

	public ArrayList<Patient> findPatients() throws DataAccessException;
}
