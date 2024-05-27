package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Patient;

public class PatientDB implements PatientDAO {
	
	// remember " " spaces when splitting up the Query with +
	private static final String findPatientByIDQuery = "SELECT patient.id, phone_number, patient.name, patient.email, patient_note "
			+ "FROM patient "
			+ "WHERE patient.id = ?";
	private static final String findPatientsQuery = "SELECT patient.id, phone_number, patient.name, patient.email, patient_note "
			+ "FROM patient";
	private PreparedStatement findPatientByID, findPatients;

	public PatientDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			findPatientByID = connection.prepareStatement(findPatientByIDQuery);
			findPatients = connection.prepareStatement(findPatientsQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public Patient findPatientById(int id) throws DataAccessException {
		try {
			findPatientByID.setInt(1, id);
			ResultSet resultSet = findPatientByID.executeQuery();
			Patient patient = null;
			if (resultSet.next()) {
				patient = buildObject(resultSet);
			}
			return patient;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find patient by id = " + id);
		}
	}
	
	@Override
	public ArrayList<Patient> findPatients() throws DataAccessException {
		try {
			ArrayList<Patient> patients = new ArrayList<>();
			ResultSet resultSet = findPatients.executeQuery();
			while (resultSet.next()) {
				patients.add(buildObject(resultSet));
			}
			return patients;
		} catch (SQLException e) {
			throw new DataAccessException(e, "No patients could be found or access to database failed");
		}
	}
	
	private Patient buildObject(ResultSet resultSet) throws SQLException {
		Patient patient = new Patient(
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getString("phone_number"),
				resultSet.getString("patient_note"),
				resultSet.getInt("id"));
		return patient;
	}
}