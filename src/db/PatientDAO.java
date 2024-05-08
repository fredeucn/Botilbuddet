package db;

import model.Patient;

public interface PatientDAO {
	public Patient findPatientById(int id) throws DataAccessException;
}
